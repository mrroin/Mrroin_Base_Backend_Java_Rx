package com.tecnojars.service.middleware.base.core.userstory;

import com.tecnojars.service.middleware.base.core.boundary.enter.MiddlewareBaseService;
import com.tecnojars.service.middleware.base.core.boundary.exit.BaseService;
import com.tecnojars.service.middleware.base.core.boundary.exit.TransformationBaseService;
import com.tecnojars.service.middleware.base.core.boundary.exit.ValidateBaseService;
import com.tecnojars.service.middleware.base.core.domain.Obj;
import com.tecnojars.service.middleware.base.core.userstory.exception.InvalidParameterException;
import io.reactivex.Maybe;
import io.vertx.core.json.JsonObject;

public class MiddlewareBaseUserStory implements MiddlewareBaseService {
	private final ValidateBaseService validateObjPaseService;
	private final TransformationBaseService transformationObjPaseService;
	private final BaseService ObjPaseService;

	public MiddlewareBaseUserStory(
			ValidateBaseService validateObjPaseService,
			TransformationBaseService transformationObjPaseService,
			BaseService ObjPaseService
			) {
		this.validateObjPaseService = validateObjPaseService;
		this.transformationObjPaseService = transformationObjPaseService;
		this.ObjPaseService = ObjPaseService;
	}

	public Maybe<Obj> getObjBalance(JsonObject request) throws Exception {
		Obj Obj = transformationObjPaseService.transformRequestToObj(request);
		return validateObjPaseService.validateRequest(Obj)
				.flatMap(value ->
						{
							System.out.println(value);
									if(value){
										return ObjPaseService.consultarSaldoObj(Obj.getObjId());
									}else{
										return Maybe.error(new InvalidParameterException("No se cuenta con los parametros requeridos"));
									}
						}
						)
				.map(it ->{
					return it;
				}
				);
	}

	@Override
	public Maybe<Obj> getObj(JsonObject request) throws Exception {
		Obj Obj = transformationObjPaseService.transformRequestToObj(request);
		return validateObjPaseService.validateRequest(Obj)
				.flatMap(value ->
						{
							System.out.println(value);
							if(value){
								return ObjPaseService.existeObj(Obj.getObjId());
							}else{
								return Maybe.error(new InvalidParameterException("No se cuenta con los parametros requeridos"));
							}
						}
				)
				.map(it ->{
							return it;
						}
				);
	}

	public Maybe<Object> getObjStatus(JsonObject request)  throws Exception {
		Obj Obj = transformationObjPaseService.transformRequestToObj(request);
		return validateObjPaseService.validateRequest(Obj)
				.flatMap(value ->
						{
							System.out.println(value);
							if(value){
								return ObjPaseService.obtieneStatusObj(Obj.getObjId());
							}else{
								return Maybe.error(new InvalidParameterException("No se cuenta con los parametros requeridos"));
							}
						}
				)
				.map(it ->{
							return it;
						}
				);
	}

	public Maybe<Object> getObjHistory(JsonObject request)  throws Exception {
		Obj Obj = transformationObjPaseService.transformRequestToObj(request);
		return validateObjPaseService.validateRequestHistory(Obj)
				.flatMap(value ->
						{
							System.out.println(value);
							if(value){
								return ObjPaseService.consultarMovimientosObj(Obj);
							}else{
								return Maybe.error(new InvalidParameterException("No se cuenta con los parametros requeridos"));
							}
						}
				)
				.map(it ->{
							return it;
						}
				);
	}

	@Override
	public Maybe<Object> getObjRecharges(JsonObject request) throws Exception {
		Obj Obj = transformationObjPaseService.transformRequestToObj(request);
		return validateObjPaseService.validateRequestHistory(Obj)
				.flatMap(value ->
						{
							System.out.println(value);
							if(value){
								return ObjPaseService.consultarRecargasObj(Obj);
							}else{
								return Maybe.error(new InvalidParameterException("No se cuenta con los parametros requeridos"));
							}
						}
				)
				.map(it ->{
							return it;
						}
				);
	}
}
