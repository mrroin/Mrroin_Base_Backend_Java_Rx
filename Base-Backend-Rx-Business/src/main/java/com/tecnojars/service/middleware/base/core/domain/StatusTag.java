package com.tecnojars.service.middleware.base.core.domain;

import java.util.Date;

public class StatusObj {
    String ObjId;

    String promotor;

    String motivo;

    String status;

    String numtar;

    public String getObjId() {
        return ObjId;
    }

    public void setObjId(String ObjId) {
        this.ObjId = ObjId;
    }

    public String getPromotor() {
        return promotor;
    }

    public void setPromotor(String promotor) {
        this.promotor = promotor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumtar() {
        return numtar;
    }

    public void setNumtar(String numtar) {
        this.numtar = numtar;
    }
}
