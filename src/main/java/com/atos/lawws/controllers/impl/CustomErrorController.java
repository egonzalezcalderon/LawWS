/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.controllers.impl;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a637201
 */
@RestController
public class CustomErrorController implements ErrorController{
    protected static final String ERROR_PATH = "/error";
        
    @RequestMapping(value = ERROR_PATH)
    public String error() {
        return "core/error";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
    
}