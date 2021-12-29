package com.tecnojars.service.middleware.base.core.boundary.exit;

import com.tecnojars.service.middleware.base.core.domain.Obj;
import io.vertx.core.json.JsonObject;

public interface TransformationBaseService {
	Obj transformRequestToObj(JsonObject request) throws Exception;
	String transformObjToJson(Obj obj) throws Exception;
}
