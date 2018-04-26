/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.TranslatableBussinessObject;
import com.atos.lawws.dtos.impl.RoleDto;
import com.atos.lawws.dtos.impl.UserDto;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author a637201
 */
public class UserBo extends TranslatableBussinessObject<UserDto> implements UserDetails {

    protected Integer id;
    protected String name;
    protected String password;
    protected String description;
    protected LawWSListBo<RoleDto, RoleBo> roles = new LawWSListBo<RoleDto, RoleBo>();
    
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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LawWSListBo<RoleDto, RoleBo> getRoles() {
        return roles;
    }

    public void setRoles(LawWSListBo<RoleDto, RoleBo> roles) {
        this.roles = roles;
    }
    
    public Boolean getMantRole() {
        return isRolPresent("MANTENIMIENTO");
    }
    
    public void setMantRole(Boolean mantRole) {
        setRolValue(1, "MANTENIMIENTO", mantRole);
    }    
    
    public Boolean getAdmRole() {
        return isRolPresent("ADMINISTRACION");
    }
    
    public void setAdmRole(Boolean admRole) {
        setRolValue(2, "ADMINISTRACION", admRole);
    }
    
    protected Boolean isRolPresent(String rolName) {
        for (RoleBo role : roles.getElements()) {
            if (role.getName().trim().equals(rolName.trim())) {
                return true;
            }
        }
        return false;
    }
    
    protected void setRolValue(Integer rolId, String rolName, Boolean value) {
        if (value) {
            RoleBo newRole = new RoleBo();
            newRole.setId(rolId);
            newRole.setName(rolName);
            roles.getElements().add(newRole);
        }
    }
    
    @Override
    public UserDto translate() {
        UserDto user = translate(new UserDto());
        user.setRoles(new HashSet(roles.translate()));
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        
        for (RoleBo role : roles.getElements()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
