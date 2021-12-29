package com.tecnojars.service.middleware.base.periphery.service.implementation;

import com.tecnojars.service.middleware.base.core.userstory.MiddlewareBaseUserStory;
import com.tecnojars.service.middleware.base.core.userstory.exception.InvalidParameterException;
import com.tecnojars.service.middleware.base.core.userstory.exception.ServiceBaseException;
import com.tecnojars.service.middleware.base.core.userstory.exception.TransformationBaseException;
import com.tecnojars.service.middleware.base.periphery.service.BaseManagerService;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;
import io.vertx.core.Vertx;
import io.vertx.ext.web.handler.CorsHandler;

public class BaseManagerServiceImpl implements BaseManagerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseManagerServiceImpl.class);
	private Vertx vertx;
	MiddlewareBaseUserStory middlewareObjPaseUserStory;
	TransformationObjPaseServiceImpl transformationObjPaseServiceImpl;
	public BaseManagerServiceImpl(Vertx vertx) {
		this.vertx = vertx;
		this.transformationObjPaseServiceImpl = new TransformationObjPaseServiceImpl();
		this.middlewareObjPaseUserStory = new MiddlewareBaseUserStory(
				new ValidateBaseServiceImpl(),
				this.transformationObjPaseServiceImpl,
				new BaseServiceImpl());
	}

	public void getBalanceObjPase(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) throws Exception {
		JsonObject resultJson = new JsonObject();
		System.out.println(context.getParams());
		JsonObject request = (JsonObject) context.getParams().getValue("path");
		middlewareObjPaseUserStory.getObjBalance(request)
				.subscribe(response ->{
					resultJson.put("status","OK");
					JsonObject item = new JsonObject(Json.encode(response));
					resultJson.put("data", item);
					resultHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(resultJson)));
				},e->{
					System.out.println("ocurrio un error.....");
					Throwable throwable = (Throwable) e;
					if(throwable!=null &&
							(
									throwable instanceof InvalidParameterException
									|| throwable instanceof ServiceBaseException
											|| throwable instanceof TransformationBaseException
							)
					){
						resultJson.put("status","BAD");
						resultJson.put("code","500_3_600");
						resultJson.put("message",throwable.getMessage());
					}else{
						if(throwable !=null)
							throwable.printStackTrace();
						resultJson.put("status","BAD");
						resultJson.put("code","500_3_000");
						resultJson.put("message","An internal error occurred");
					}
					resultHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(resultJson)));
				});
	}

	@Override
	public void geObjPase(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) throws Exception {
		JsonObject resultJson = new JsonObject();
		System.out.println(context.getParams());
		JsonObject request = (JsonObject) context.getParams().getValue("path");
		middlewareObjPaseUserStory.getObj(request)
				.subscribe(response ->{
					resultJson.put("status","OK");
					JsonObject item = new JsonObject(Json.encode(response));
					resultJson.put("data", item);
					resultHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(resultJson)));
				},e->{
					System.out.println("ocurrio un error.....");
					Throwable throwable = (Throwable) e;
					if(throwable!=null &&
							(
									throwable instanceof InvalidParameterException
											|| throwable instanceof ServiceBaseException
											|| throwable instanceof TransformationBaseException
							)
					){
						resultJson.put("status","BAD");
						resultJson.put("code","500_3_600");
						resultJson.put("message",throwable.getMessage());
					}else{
						if(throwable !=null)
							throwable.printStackTrace();
						resultJson.put("status","BAD");
						resultJson.put("code","500_3_000");
						resultJson.put("message","An internal error occurred");
					}
					resultHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(resultJson)));
				});
	}

	@Override
	public void getStatusObjPase(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) throws Exception {
		JsonObject resultJson = new JsonObject();
		System.out.println(context.getParams());
		JsonObject request = (JsonObject) context.getParams().getValue("path");
		middlewareObjPaseUserStory.getObjStatus(request)
				.subscribe(response ->{
					resultJson.put("status","OK");
					JsonObject item = new JsonObject(Json.encode(response));
					resultJson.put("data", item);
					resultHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(resultJson)));
				},e->{
					System.out.println("ocurrio un error.....");
					Throwable throwable = (Throwable) e;
					if(throwable!=null &&
							(
									throwable instanceof InvalidParameterException
											|| throwable instanceof ServiceBaseException
											|| throwable instanceof TransformationBaseException
							)
					){
						resultJson.put("status","BAD");
						resultJson.put("code","500_3_600");
						resultJson.put("message",throwable.getMessage());
					}else{
						if(throwable !=null)
							throwable.printStackTrace();
						resultJson.put("status","BAD");
						resultJson.put("code","500_3_000");
						resultJson.put("message","An internal error occurred");
					}
					resultHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(resultJson)));
				});
	}

	@Override
	public void getHistoryObjPase(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) throws Exception {
		JsonObject resultJson = new JsonObject();
		System.out.println(context.getParams());
		JsonObject request = (JsonObject) context.getParams().getValue("query");
		middlewareObjPaseUserStory.getObjHistory(request)
				.subscribe(response ->{
					resultJson.put("status","OK");
					JsonArray item = new JsonArray(Json.encode(response));
					resultJson.put("data", item);
					resultHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(resultJson)));
				},e->{
					System.out.println("ocurrio un error.....");
					Throwable throwable = (Throwable) e;
					if(throwable!=null &&
							(
									throwable instanceof InvalidParameterException
											|| throwable instanceof ServiceBaseException
											|| throwable instanceof TransformationBaseException
							)
					){
						resultJson.put("status","BAD");
						resultJson.put("code","500_3_600");
						resultJson.put("message",throwable.getMessage());
					}else{
						if(throwable !=null)
							throwable.printStackTrace();
						resultJson.put("status","BAD");
						resultJson.put("code","500_3_000");
						resultJson.put("message","An internal error occurred");
					}
					resultHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(resultJson)));
				});
	}

	@Override
	public void getRechargesObjPase(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) throws Exception {
		JsonObject resultJson = new JsonObject();
		System.out.println(context.getParams());
		JsonObject request = (JsonObject) context.getParams().getValue("query");
		middlewareObjPaseUserStory.getObjRecharges(request)
				.subscribe(response ->{
					resultJson.put("status","OK");
					JsonArray item = new JsonArray(Json.encode(response));
					resultJson.put("data", item);
					resultHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(resultJson)));
				},e->{
					System.out.println("ocurrio un error.....");
					Throwable throwable = (Throwable) e;
					if(throwable!=null &&
							(
									throwable instanceof InvalidParameterException
											|| throwable instanceof ServiceBaseException
											|| throwable instanceof TransformationBaseException
							)
					){
						resultJson.put("status","BAD");
						resultJson.put("code","500_3_600");
						resultJson.put("message",throwable.getMessage());
					}else{
						if(throwable !=null)
							throwable.printStackTrace();
						resultJson.put("status","BAD");
						resultJson.put("code","500_3_000");
						resultJson.put("message","An internal error occurred");
					}
					resultHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(resultJson)));
				});
	}

	@Override
	public void healthCheck(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) {
		JsonObject resultJson = new JsonObject();
		resultJson.put("status","OK");
		resultHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(resultJson)));
	}

}
