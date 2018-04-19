/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.pseudocontrollers.core;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author a637201
 */
public abstract class PseudoController<ModelAttr> {
    
    public abstract void fillControllerParameters(ModelAndView model);
        
    public abstract ModelAndView processRequest(ModelAndView modelAndView, ModelAttr modelAttribute);
    
}
