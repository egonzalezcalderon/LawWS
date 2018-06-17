/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.controllers.impl;

import com.atos.lawws.config.SecurityConfig;
import com.atos.lawws.tools.SessionTool;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author a637201
 */
public class LawWSController {
    
    protected ModelAndView getBaseModelAndView(String view) {
        ModelAndView baseModelAndView = new ModelAndView(view);
        baseModelAndView.addObject("username", SessionTool.getCurrentUserName());
        baseModelAndView.addObject("userroles", SessionTool.getCurrentUserAuthorities());
        baseModelAndView.addObject("administrationrol", SecurityConfig.ADMINISTRATION_ROL);
        baseModelAndView.addObject("maintenancerol", SecurityConfig.MAINTENANCE_ROL);
        return baseModelAndView;
    }
    
}
