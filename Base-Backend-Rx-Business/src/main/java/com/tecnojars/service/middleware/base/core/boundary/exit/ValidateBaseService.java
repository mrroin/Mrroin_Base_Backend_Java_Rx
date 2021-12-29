package com.tecnojars.service.middleware.base.core.boundary.exit;

import com.tecnojars.service.middleware.base.core.domain.Obj;
import io.reactivex.Maybe;

public interface ValidateBaseService {
	Maybe<Boolean> validateRequest(Obj Obj);
	Maybe<Boolean> validateRequestHistory(Obj Obj);
}
