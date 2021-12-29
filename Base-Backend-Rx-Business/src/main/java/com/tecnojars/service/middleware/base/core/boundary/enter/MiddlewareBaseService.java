package com.tecnojars.service.middleware.base.core.boundary.enter;

import com.tecnojars.service.middleware.base.core.domain.Obj;
import io.reactivex.Maybe;
import io.vertx.core.json.JsonObject;

public interface MiddlewareBaseService {
	Maybe<Obj> getObjBalance(JsonObject request) throws Exception;
	Maybe<Obj> getObj(JsonObject request) throws Exception;
	Maybe<Object> getObjStatus(JsonObject request)  throws Exception;
	Maybe<Object> getObjHistory(JsonObject request)  throws Exception;
	Maybe<Object> getObjRecharges(JsonObject request)  throws Exception;
}
