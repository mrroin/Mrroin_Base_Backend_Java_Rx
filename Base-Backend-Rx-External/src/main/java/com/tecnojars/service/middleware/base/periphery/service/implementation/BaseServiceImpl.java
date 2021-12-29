package com.tecnojars.service.middleware.base.periphery.service.implementation;

import com.tecnojars.service.middleware.base.core.boundary.exit.BaseService;
import com.tecnojars.service.middleware.base.core.domain.RecordObj;
import com.tecnojars.service.middleware.base.core.domain.StatusObj;
import com.tecnojars.service.middleware.base.core.domain.Obj;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseServiceImpl implements BaseService {

    public Maybe<Obj> consultarSaldoObj(String ObjId) {
        System.out.println("obteniendo saldo....");
        Obj result = new Obj();
        result.setObjId(ObjId);
        result.setBalance(1000d);
        return Maybe.just(result);
        //return Maybe.error(new ServiceObjPaseException("Error al ejecutar el servicio."));
    }

    @Override
    public Maybe<Obj> existeObj(String ObjId) {
        System.out.println("existe Obj....");
        Obj result = new Obj();
        result.setObjId(ObjId);
        result.setBalance(1000d);
        result.setAlias("alias1");
        result.setPaymentType(1);
        return Maybe.just(result);
    }

    public Maybe<StatusObj> obtieneStatusObj(String ObjId) {
        System.out.println("obteniendo estatus....");
        StatusObj result = new StatusObj();
        result.setObjId(ObjId);
        result.setPromotor("Promotor 1");
        result.setStatus("Active");
        result.setNumtar("XXXX-XXXX-XXXX");
        return Maybe.just(result);
        //return Maybe.error(new ServiceObjPaseException("Error al ejecutar el servicio."));
    }

    public Maybe<List<RecordObj>> consultarMovimientosObj(Obj Obj) {
        System.out.println("obteniendo movimientos....");
        RecordObj result = new RecordObj();
        result.setCarril("carril 1");
        result.setCaseta("caseta 013");
        result.setClase(1);
        result.setEjes(2);
        result.setFecha(new Date().getTime());
        result.setMonto(129d);
        result.setRodada(2);
        result.setTipoMovimiento(2);
        result.setTramo("tramo 2");
        result.setFolio("F-00000001");
        result.setRecorrido("rec 001");
        result.setFechaPago(new Date().getTime());
        result.setNomcarril("Carril name");
        List<RecordObj> list = new ArrayList<>();
        list.add(result);
        return Maybe.just(list);
    }

    @Override
    public Maybe<List<RecordObj>> consultarRecargasObj(Obj Obj) {
        System.out.println("obteniendo recargas....");
        RecordObj result = new RecordObj();
        result.setCarril("carril 1");
        result.setCaseta("caseta 013");
        result.setClase(1);
        result.setEjes(2);
        result.setFecha(new Date().getTime());
        result.setMonto(129d);
        result.setRodada(2);
        result.setTipoMovimiento(2);
        result.setTramo("tramo 2");
        result.setFolio("F-00000001");
        result.setRecorrido("rec 001");
        result.setFechaPago(new Date().getTime());
        result.setNomcarril("Carril name");
        List<RecordObj> list = new ArrayList<>();
        list.add(result);
        return Maybe.just(list);
    }
}
