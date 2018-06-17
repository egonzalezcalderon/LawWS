/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.daos.core;

import com.atos.lawws.dtos.impl.UserDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author a637201
 */
@Repository
public interface LawWSUsersDao extends JpaRepository<UserDto, Integer> {   
    
    @Query("select users from UserDto users where users.name like %:name% and users.description like %:description%")
    public List<UserDto> getUsersWithNameAndDescription(
            @Param("name") String name,
            @Param("description") String description);
    
    @Query("select users from UserDto users where users.name = :name")
    public List<UserDto> getUserWithName(
            @Param("name") String name);    
}
