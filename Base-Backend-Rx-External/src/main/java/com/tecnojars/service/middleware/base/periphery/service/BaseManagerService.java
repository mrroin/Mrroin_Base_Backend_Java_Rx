package com.tecnojars.service.middleware.base.periphery.service;

import com.tecnojars.service.middleware.base.periphery.service.implementation.BaseManagerServiceImpl;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;
import io.vertx.ext.web.api.generator.WebApiServiceGen;

@WebApiServiceGen
public interface BaseManagerService {
    void getBalanceObjPase(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) throws Exception;
    void geObjPase(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) throws Exception;
    void getStatusObjPase(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) throws Exception;
    void getHistoryObjPase(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) throws Exception;
    void getRechargesObjPase(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler) throws Exception;
    void healthCheck(OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);
    static BaseManagerService create(Vertx vertx) {
        return new BaseManagerServiceImpl(vertx);
    }
}
