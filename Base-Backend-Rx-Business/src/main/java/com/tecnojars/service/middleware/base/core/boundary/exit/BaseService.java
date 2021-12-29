package com.tecnojars.service.middleware.base.core.boundary.exit;

import com.tecnojars.service.middleware.base.core.domain.RecordObj;
import com.tecnojars.service.middleware.base.core.domain.StatusObj;
import com.tecnojars.service.middleware.base.core.domain.Obj;
import io.reactivex.Maybe;
import java.util.List;

public interface BaseService {
	Maybe<Obj> consultarSaldoObj(String ObjId);
	Maybe<Obj> existeObj(String ObjId);
	Maybe<StatusObj> obtieneStatusObj(String ObjId);
	Maybe<List<RecordObj>> consultarMovimientosObj(Obj Obj);
	Maybe<List<RecordObj>> consultarRecargasObj(Obj Obj);
}
