/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.services.core;

import com.atos.lawws.bussiness.core.CRUDRequest;
import com.atos.lawws.bussiness.core.CRUDResponse;

/**
 *
 * @author a637201
 */
public abstract class CRUDService<ExtRequest, ExtResponse, IntRequest extends CRUDRequest, IntResponse extends CRUDResponse>
        implements SingleTaskService
        <ExtRequest, ExtResponse, IntRequest, IntResponse> {
    
    public IntResponse search(IntRequest request) {
        request.setToBeSearched(true);
        request.setToBeDeleted(false);
        request.setToBeInserted(false);
        return serve(request);
    }
    
    public IntResponse delete(IntRequest request) {
        request.setToBeSearched(false);
        request.setToBeDeleted(true);
        request.setToBeInserted(false);
        return serve(request);       
    }
    
    public IntResponse insert(IntRequest request) {
        request.setToBeSearched(false);
        request.setToBeDeleted(false);
        request.setToBeInserted(true);
        return serve(request);               
    }
    
    public IntResponse modify(IntRequest request) {
        request.setToBeSearched(false);
        request.setToBeDeleted(false);
        request.setToBeInserted(false);
        return serve(request);               
    }    
    
    @Override
    public IntResponse serve(IntRequest request) {
        if (request.isToBeSearched()) {
            return internalSearch(request);
        }
        
        if (request.isToBeDeleted()) {
            return internalDelete(request);
        }
        
        IntResponse response = (request.isToBeInserted())?isValidToInsert(request):isValidToModify(request);
        if (response.isOperationCorrect()) {
            return internalSave(request);
        } else {
            return response;
        }
    }
    
    protected abstract IntResponse internalSearch(IntRequest request);
    
    protected abstract IntResponse internalDelete(IntRequest request);
    
    protected abstract IntResponse internalSave(IntRequest request);
    
    protected abstract IntResponse isValidToInsert(IntRequest request);
    
    protected abstract IntResponse isValidToModify(IntRequest request);
    
}
