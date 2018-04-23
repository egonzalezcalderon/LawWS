/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.dtos.impl;

import com.atos.lawws.bussiness.impl.RoleBo;
import com.atos.lawws.bussiness.impl.UserBo;
import com.atos.lawws.dtos.core.TransformableDto;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author a637201
 */
@Entity
@Table(name = "WEB_SERVICE_PERFIL")
public class RoleDto extends TransformableDto<RoleBo> implements Serializable {
    
    protected Integer id;
    protected String name;
    protected Set<UserDto> users;
    
    @Id
    @Column(name="ID")   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="NOMBRE")      
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    @ManyToMany(mappedBy = "roles")
    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
    }

    @Override
    public RoleBo translate() {
        return translate(new RoleBo()); 
    }
}