/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.TranslatableBussinessObject;
import com.atos.lawws.dtos.impl.RoleDto;
import com.atos.lawws.dtos.impl.UserDto;

/**
 *
 * @author a637201
 */
public class RoleBo extends TranslatableBussinessObject<RoleDto> {
    
    protected Integer id;
    protected String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public RoleDto translate() {
        return translate(new RoleDto());
    }
    
    
    
}
