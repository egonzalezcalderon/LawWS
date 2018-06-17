/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.core;

/**
 *
 * @author a637201
 */
public abstract class CRUDRequest extends BussinessObject{
    
    protected boolean toBeDeleted;
    protected boolean toBeSearched;
    protected boolean toBeInserted;

    public boolean isToBeDeleted() {
        return toBeDeleted;
    }

    public void setToBeDeleted(boolean toBeDeleted) {
        this.toBeDeleted = toBeDeleted;
    }

    public boolean isToBeSearched() {
        return toBeSearched;
    }

    public void setToBeSearched(boolean toBeSearched) {
        this.toBeSearched = toBeSearched;
    }

    public boolean isToBeInserted() {
        return toBeInserted;
    }

    public void setToBeInserted(boolean toBeInserted) {
        this.toBeInserted = toBeInserted;
    }
}
