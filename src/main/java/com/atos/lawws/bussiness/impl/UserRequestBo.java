/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.BussinessObject;

/**
 *
 * @author a637201
 */
public class UserRequestBo extends BussinessObject {
    
    protected UserBo user;
    protected boolean toBeDeleted;
    protected boolean toBeSearched;

    public UserRequestBo(UserBo user, boolean toBeSearched, boolean toBeDeleted) {
        this.user = user;
        this.toBeSearched = toBeSearched;
        this.toBeDeleted = toBeDeleted;
    }
    
    public UserBo getUser() {
        return user;
    }

    public void setUser(UserBo user) {
        this.user = user;
    }
    
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
    
}
