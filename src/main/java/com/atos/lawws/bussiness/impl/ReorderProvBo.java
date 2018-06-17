/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.TranslatableBussinessObject;
import com.atos.lawws.tools.DatesTool;
import com.atos.lawws.webservice.xml.consultareordersprov.ReorderProv;
import java.util.Date;

/**
 *
 * @author a637201
 */
public class ReorderProvBo extends TranslatableBussinessObject<ReorderProv> {
        
    protected String codPluma;
    protected String pieza;
    protected int cantidad;
    protected Date fechaImp;

    public String getCodPluma() {
        return codPluma;
    }

    public void setCodPluma(String codPluma) {
        this.codPluma = codPluma;
    }

    public String getPieza() {
        return pieza;
    }

    public void setPieza(String pieza) {
        this.pieza = pieza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaImp() {
        return fechaImp;
    }

    public void setFechaImp(Date fechaImp) {
        this.fechaImp = fechaImp;
    }

    @Override
    public ReorderProv translate() {
        ReorderProv reorderProv = translate(new ReorderProv());
        reorderProv.setFechaImportacion(DatesTool.getXMLGregorianCalendarDate(fechaImp));
        return reorderProv;
    }
    
}
