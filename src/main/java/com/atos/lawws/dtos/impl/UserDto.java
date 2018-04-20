/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.dtos.impl;

import com.atos.lawws.bussiness.impl.UserBo;
import com.atos.lawws.dtos.core.TransformableDto;
import com.atos.lawws.security.encription.UserPasswordEncryptor;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author a637201
 */
@Entity
@Table(name = "WEB_SERVICE_USUARIO")
public class UserDto extends TransformableDto<UserBo> implements Serializable {
    
    protected Integer id;
    protected String name;
    protected String password;
    protected String description;
    
    @Id
    @Column(name="ID")   
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WEB_SERVICE_USER_SEQ")
    @SequenceGenerator(name = "WEB_SERVICE_USER_SEQ", sequenceName = "WEB_SERVICE_USER_SEQ", allocationSize = 1, initialValue = 1)        
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

    @Column(name="PASSWORD")  
    @Convert(converter = UserPasswordEncryptor.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="DESCRIPCION")       
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public UserBo translate() {
        return translate(new UserBo());
    }  

}