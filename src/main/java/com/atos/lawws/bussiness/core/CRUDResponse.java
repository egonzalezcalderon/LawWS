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
public abstract class CRUDResponse extends BussinessObject {
    
    protected String operationResult = "";
    protected boolean operationCorrect = false;

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(boolean operationCorrect, String operationResult) {
        this.operationResult = operationResult;
        this.operationCorrect = operationCorrect;
    }

    public boolean isOperationCorrect() {
        return operationCorrect;
    }
}
