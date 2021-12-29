package com.tecnojars.service.middleware.base.periphery.service.implementation;

import com.tecnojars.service.middleware.base.core.boundary.exit.TransformationBaseService;
import com.tecnojars.service.middleware.base.core.domain.Obj;
import com.tecnojars.service.middleware.base.core.userstory.exception.TransformationBaseException;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import io.vertx.core.json.JsonObject;

public class TransformationObjPaseServiceImpl implements TransformationBaseService {

    @Override
    public Obj transformRequestToObj(JsonObject request) throws TransformationBaseException {
        try{
            Obj data = new JSONDeserializer<Obj>()
                    .deserialize(request.toString(), Obj.class);
            return data;
        }catch(Exception e){
            throw new TransformationBaseException("Error al deserializar request:: " + e.getMessage());
        }

    }

    @Override
    public String transformObjToJson(Obj obj) {
        String json = new JSONSerializer().exclude("*.class")
                .serialize(obj);
        return json;
    }
}
