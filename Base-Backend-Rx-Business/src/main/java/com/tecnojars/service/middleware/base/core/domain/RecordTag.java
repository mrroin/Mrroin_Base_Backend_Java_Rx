package com.tecnojars.service.middleware.base.core.domain;

import java.util.Date;

public class RecordObj {
    String carril;

    String caseta;

    Integer clase;

    Integer ejes;

    Long fecha;

    Double monto;

    Integer rodada;

    Integer tipoMovimiento;

    String tramo;

    String folio;

    String recorrido;

    Long fechaPago;

    String nomcarril;

    public String getCarril() {
        return carril;
    }

    public void setCarril(String carril) {
        this.carril = carril;
    }

    public String getCaseta() {
        return caseta;
    }

    public void setCaseta(String caseta) {
        this.caseta = caseta;
    }

    public Integer getClase() {
        return clase;
    }

    public void setClase(Integer clase) {
        this.clase = clase;
    }

    public Integer getEjes() {
        return ejes;
    }

    public void setEjes(Integer ejes) {
        this.ejes = ejes;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public Integer getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Integer tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }

    public Long getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Long fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getNomcarril() {
        return nomcarril;
    }

    public void setNomcarril(String nomcarril) {
        this.nomcarril = nomcarril;
    }
}
