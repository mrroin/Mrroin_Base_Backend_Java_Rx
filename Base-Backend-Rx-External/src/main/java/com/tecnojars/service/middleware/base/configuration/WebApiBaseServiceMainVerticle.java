package com.tecnojars.service.middleware.base.configuration;

import com.tecnojars.service.middleware.base.periphery.service.BaseManagerService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CorsHandler;
import io.vertx.serviceproxy.ServiceBinder;
import java.util.HashSet;
import java.util.Set;

public class WebApiBaseServiceMainVerticle extends AbstractVerticle {
    HttpServer server;
    ServiceBinder serviceBinder;

    MessageConsumer<JsonObject> consumer;

    private void startTransactionService() {
        serviceBinder = new ServiceBinder(vertx);

        BaseManagerService ObjPaseManagerService = BaseManagerService.create(vertx);

        consumer = serviceBinder
                .setAddress("tecnojars.base")
                .register(BaseManagerService.class, ObjPaseManagerService);
    }

    /**
     * This method constructs the router factory, mounts services and handlers and starts the http server with built router
     * @return
     */
    private Future<Void> startHttpServer() {
        Future<Void> future = Future.future();
        OpenAPI3RouterFactory.create(this.vertx, "/Base.yaml", openAPI3RouterFactoryAsyncResult -> {
            if (openAPI3RouterFactoryAsyncResult.succeeded()) {
                OpenAPI3RouterFactory routerFactory = openAPI3RouterFactoryAsyncResult.result();
                // Mount services on event bus based on extensions
                routerFactory.mountServicesFromExtensions();

                // Generate the router
                Router router = routerFactory.getRouter();
               Set<String> allowedHeaders = new HashSet<>();
               allowedHeaders.add("Access-Control-Allow-Method");
               allowedHeaders.add("access-control-allow-origin");
               allowedHeaders.add("Access-Control-Allow-Origin");
               allowedHeaders.add("Content-Type");
               allowedHeaders.add("Authorization");
               allowedHeaders.add("X-Requested-With");
               allowedHeaders.add("Content-Length");
               allowedHeaders.add("Accept");
               allowedHeaders.add("Origin");
               allowedHeaders.add("Access-Control-Allow-Credentials");
               Set<HttpMethod> allowedMethods = new HashSet<>();
               allowedMethods.add(HttpMethod.GET);
               allowedMethods.add(HttpMethod.POST);
               allowedMethods.add(HttpMethod.OPTIONS);
               router.route().handler(CorsHandler.create("*")
                       .allowedHeaders(allowedHeaders)
                       .allowedMethods(allowedMethods)
                );
                server = vertx.createHttpServer(new HttpServerOptions().setPort(8080));
                server.requestHandler(router).listen(ar -> {
                    if (ar.succeeded()) future.complete();
                    else future.fail(ar.cause());
                });
            } else {
                // Something went wrong during router factory initialization
                future.fail(openAPI3RouterFactoryAsyncResult.cause());
            }
        });
        return future;
    }

    @Override
    public void start(Future<Void> future) {
        startTransactionService();
        startHttpServer().setHandler(future.completer());
    }

    /**
     * This method closes the http server and unregister all services loaded to Event Bus
     */
    @Override
    public void stop(){
        this.server.close();
        consumer.unregister();
    }


    public static void main(String [] args){
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new WebApiBaseServiceMainVerticle());
    }
}
