package com.tecnojars.service.middleware.base.periphery.service.implementation;

import com.tecnojars.service.middleware.base.core.boundary.exit.ValidateBaseService;
import com.tecnojars.service.middleware.base.core.domain.Obj;
import com.tecnojars.service.middleware.base.core.userstory.exception.InvalidParameterException;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;
import io.vertx.ext.web.api.generator.WebApiServiceGen;
import org.everit.json.schema.ValidationException;

/**
 *
 * Validates against schema.
 */
public class ValidateBaseServiceImpl implements ValidateBaseService {
    /**
     * Validates a given JSON Object against the a given profile schema.
     * @param Obj
     * @throws InvalidParameterException
     */
    public Maybe<Boolean> validateRequest(Obj Obj) {
        try{
            return Maybe.just(Obj != null && !Obj.getObjId().isEmpty());
        }catch(Exception e){
            return Maybe.error(new InvalidParameterException("No se cuenta con los parametros requeridos"));
        }
    }

    @Override
    public Maybe<Boolean> validateRequestHistory(Obj Obj) {
        try{
            return Maybe.just(Obj != null && !Obj.getObjId().isEmpty()
                    && Obj.getStartDate() != 0L && Obj.getEndDate() != 0L
                    && Obj.getType() != 0);
        }catch(Exception e){
            return Maybe.error(new InvalidParameterException("No se cuenta con los parametros requeridos"));
        }
    }
}
