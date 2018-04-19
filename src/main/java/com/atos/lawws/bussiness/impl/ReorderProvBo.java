/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.TranslatableBussinessObject;
import com.atos.lawws.webservice.xml.consultareordersprov.ReorderProv;

/**
 *
 * @author a637201
 */
public class ReorderProvBo extends TranslatableBussinessObject<ReorderProv> {
        
    protected int cantidadPiezas;

    public int getCantidadPiezas() {
        return cantidadPiezas;
    }

    public void setCantidadPiezas(int cantidadPiezas) {
        this.cantidadPiezas = cantidadPiezas;
    }

    @Override
    public ReorderProv translate() {
        return translate(new ReorderProv());
    }
    
}
