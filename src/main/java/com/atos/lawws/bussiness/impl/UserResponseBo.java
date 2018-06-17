/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.BussinessObject;
import com.atos.lawws.bussiness.core.CRUDResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a637201
 */
public class UserResponseBo extends CRUDResponse {
    
    protected List<UserBo> users = new ArrayList<UserBo>();    
    
    public List<UserBo> getUsers() {
        return users;
    }

    public void setUsers(List<UserBo> users) {
        this.users = users;
    }    
}
