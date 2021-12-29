package com.tecnojars.service.middleware.base.periphery.service.implementation;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.reactivex.core.http.HttpServerResponse;
import io.vertx.reactivex.ext.web.RoutingContext;

public class HealthCheckController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthCheckController.class);

    public void doCheck(RoutingContext routingContext) {
        LOGGER.info("**********Health******");
        HttpServerResponse response = routingContext.response();
        response.putHeader("Content-Type", "application/json");
        response.setStatusCode(200);
        response.end("{\"Estatus\":\"OK\",\"Version\":\"21-05-2019 12:14\"}");
    }
}
