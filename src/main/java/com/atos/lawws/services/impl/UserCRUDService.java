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
import com.atos.lawws.services.core.CRUDService;
import com.atos.lawws.tools.SessionTool;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author a637201
 */
@Service
public class UserCRUDService extends CRUDService<
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
    protected UserResponseBo internalSearch(UserRequestBo request) {
        UserResponseBo response = new UserResponseBo();
        SecurityContextHolder.getContext().getAuthentication();
        List<UserDto> foundUsers = lawWSUsersDao.getUsersWithNameAndDescription(request.getUser().getName(), request.getUser().getDescription());
                
        for (UserDto foundUser : foundUsers) {
            response.getUsers().add(foundUser.translate());
        }
                
        return response;
    }
    
    @Override
    protected UserResponseBo internalDelete(UserRequestBo request) {
        UserResponseBo response = new UserResponseBo();
        try {
            lawWSUsersDao.delete(request.getUser().translate());
            response.setOperationResult(true, "Usuario Eliminado Correctamente");
        } catch (Exception e) {
            response.setOperationResult(false, "Ocurrio un error Eliminando el Usuario");
        }
        return response;
    }
    
    @Override
    protected UserResponseBo internalSave(UserRequestBo request) {
        UserResponseBo response = new UserResponseBo();
        try {
            lawWSUsersDao.save(request.getUser().translate());
            response.setOperationResult(true, "Usuario Guardado Correctamente");
        } catch (Exception e) {
            response.setOperationResult(false, "Ocurrio un error Guardando el Usuario");
        }
        return response;
    } 

    @Override
    protected UserResponseBo isValidToInsert(UserRequestBo request) {
        UserResponseBo response = new UserResponseBo();
        
        String errors = "";
        
        if (lawWSUsersDao.getUserWithName(request.getUser().getName()).size() != 0) {
            errors += "Ya existe un usuario con el nombre ingresado\n";
        } 
        
        errors += validate(request);
        
        response.setOperationResult((errors.equals("")), errors);
        
        return response;
    }
    
    @Override
    protected UserResponseBo isValidToModify(UserRequestBo request) {
        UserResponseBo response = new UserResponseBo();
        
        String errors = validate(request);
        
        response.setOperationResult((errors.equals("")), errors);
        
        return response;
    }    
    
    public String validate(UserRequestBo request) {
        String errors = "";
        
        if (request.getUser().getName().trim().length() == 0) {
            errors += "El Campo Nombre es Obligatorio. ";
        }
        
        if (request.getUser().getPassword().trim().length() == 0) {
            errors += "El Campo Password es Obligatorio. ";
        }        
    
        if (request.getUser().getDescription().trim().length() == 0) {
            errors += "El Campo Descripcion es Obligatorio. ";
        }

        if (request.getUser().getRoles().getElements().size() == 0) {
            errors += "Se debe Seleccionar por lo menos un Rol. ";
        }       
        
        return errors;
    }
    
}
