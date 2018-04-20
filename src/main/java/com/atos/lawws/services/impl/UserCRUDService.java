/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.services.impl;

import com.atos.lawws.bussiness.impl.UserRequestBo;
import com.atos.lawws.bussiness.impl.UserResponseBo;
import com.atos.lawws.daos.core.LawWSUsersDao;
import com.atos.lawws.dtos.impl.UserDto;
import com.atos.lawws.services.core.SingleTaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a637201
 */
@Service
public class UserCRUDService implements SingleTaskService<
        UserRequestBo,
        UserResponseBo,
        UserRequestBo,
        UserResponseBo> {

    @Autowired
    LawWSUsersDao lawWSUsersDao;
    
    @Override
    public UserRequestBo translateRequest(UserRequestBo extRequest) {
        return extRequest;
    }

    @Override
    public UserResponseBo translateResponse(UserResponseBo intResponse) {
        return intResponse;
    }

    @Override
    public UserResponseBo serve(UserRequestBo request) {
        if (request.isToBeSearched()) {
            return searchUser(request);
        }
        
        if (request.isToBeDeleted()) {
            return deleteUser(request);
        }
        
        return saveUser(request);
    }
    
    protected UserResponseBo searchUser(UserRequestBo request) {
        UserResponseBo response = new UserResponseBo();
        List<UserDto> foundUsers = lawWSUsersDao.getUsersWithNameAndDescription(request.getUser().getName(), request.getUser().getDescription());
                
        for (UserDto foundUser : foundUsers) {
            response.getUsers().add(foundUser.translate());
        }
                
        return response;
    }
    
    protected UserResponseBo deleteUser(UserRequestBo request) {
        UserResponseBo response = new UserResponseBo();
        try {
            lawWSUsersDao.delete(request.getUser().translate());
            response.setOperationResult(true, "Usuario Eliminado Correctamente");
        } catch (Exception e) {
            response.setOperationResult(false, "Ocurrio un error Eliminando el Usuario");
        }
        return response;
    }
    
    protected UserResponseBo saveUser(UserRequestBo request) {
        UserResponseBo response = new UserResponseBo();
        try {
            lawWSUsersDao.save(request.getUser().translate());
            response.setOperationResult(true, "Usuario Eliminado Correctamente");
        } catch (Exception e) {
            response.setOperationResult(false, "Ocurrio un error Guardando el Usuario");
        }
        return response;
    }
}
