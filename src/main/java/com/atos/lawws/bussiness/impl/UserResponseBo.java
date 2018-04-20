/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.BussinessObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a637201
 */
public class UserResponseBo extends BussinessObject {
    
    protected List<UserBo> users = new ArrayList<UserBo>();    
    protected String operationResult = "";
    protected boolean operationCorrect = false;
    
    public List<UserBo> getUsers() {
        return users;
    }

    public void setUsers(List<UserBo> users) {
        this.users = users;
    }

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
