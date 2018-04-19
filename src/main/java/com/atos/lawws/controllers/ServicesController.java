/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.controllers;

import com.atos.lawws.bussiness.impl.Proveedor;
import com.atos.lawws.pseudocontrollers.impl.CantidadReordersProvPseudoController;
import com.atos.lawws.pseudocontrollers.impl.CantidadReordersVWPseudoController;
import com.atos.lawws.pseudocontrollers.impl.ConsultaReordersProvPseudoController;
import com.atos.lawws.pseudocontrollers.impl.ConsultaReordersVWPseudoController;
import com.atos.lawws.pseudocontrollers.impl.FechasReordersProvPseudoController;
import com.atos.lawws.pseudocontrollers.impl.FechasReordersVWPseudoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author a637201
 */
@Controller
public class ServicesController {
    
    @Autowired 
    CantidadReordersProvPseudoController cantidadReordersProvPseudoController;
    @Autowired 
    CantidadReordersVWPseudoController cantidadReordersVWPseudoController;
    @Autowired 
    ConsultaReordersProvPseudoController consultaReordersProvPseudoController;
    @Autowired 
    ConsultaReordersVWPseudoController consultaReordersVWPseudoController;
    @Autowired 
    FechasReordersProvPseudoController fechasReordersProvPseudoController;
    @Autowired 
    FechasReordersVWPseudoController fechasReordersVWPseudoController;
      
    protected ModelAndView getBasicModelAndView() {
        ModelAndView basicModelAndView = new ModelAndView("core/services");
        cantidadReordersProvPseudoController.fillControllerParameters(basicModelAndView);
        cantidadReordersVWPseudoController.fillControllerParameters(basicModelAndView);
        consultaReordersProvPseudoController.fillControllerParameters(basicModelAndView);
        consultaReordersVWPseudoController.fillControllerParameters(basicModelAndView);
        fechasReordersProvPseudoController.fillControllerParameters(basicModelAndView);
        fechasReordersVWPseudoController.fillControllerParameters(basicModelAndView);
        return basicModelAndView; 
    }
     
    @RequestMapping(value="/maintenance/services", method = RequestMethod.GET)
    public ModelAndView services(Model model) {
        return getBasicModelAndView();
    }   
     
    @RequestMapping(value="/maintenance/services/cantidadreordersprov", method = RequestMethod.GET)
    public ModelAndView cantidadReordersProv(Model model) {
        return getBasicModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/cantidadreordersprov", method = RequestMethod.POST)
    public ModelAndView cantidadReordersProv(@ModelAttribute Proveedor proveedor) {
        return cantidadReordersProvPseudoController.processRequest(getBasicModelAndView(), proveedor);
    }
    
    @RequestMapping(value="/maintenance/services/cantidadreordersvw", method = RequestMethod.GET)
    public ModelAndView cantidadReordersVW(Model model) {
        return getBasicModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/cantidadreordersvw", method = RequestMethod.POST)
    public ModelAndView cantidadReordersVW(@ModelAttribute Proveedor proveedor) {
        return cantidadReordersVWPseudoController.processRequest(getBasicModelAndView(), proveedor);
    }

    @RequestMapping(value="/maintenance/services/consultareordersprov", method = RequestMethod.GET)
    public ModelAndView consultaReordersProv(Model model) {
        return getBasicModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/consultareordersprov", method = RequestMethod.POST)
    public ModelAndView consultaReordersProv(@ModelAttribute Proveedor proveedor) {
        return consultaReordersProvPseudoController.processRequest(getBasicModelAndView(), proveedor);
    }

    @RequestMapping(value="/maintenance/services/consultareordersvw", method = RequestMethod.GET)
    public ModelAndView consultaReordersVW(Model model) {
        return getBasicModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/consultareordersvw", method = RequestMethod.POST)
    public ModelAndView consultaReordersVW(@ModelAttribute Proveedor proveedor) {
        return consultaReordersVWPseudoController.processRequest(getBasicModelAndView(), proveedor);
    }

    @RequestMapping(value="/maintenance/services/fechasreordersprov", method = RequestMethod.GET)
    public ModelAndView fechasReordersProv(Model model) {
        return getBasicModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/fechasreordersprov", method = RequestMethod.POST)
    public ModelAndView fechasReordersProv(@ModelAttribute Proveedor proveedor) {
        return fechasReordersProvPseudoController.processRequest(getBasicModelAndView(), proveedor);
    }    
    
    @RequestMapping(value="/maintenance/services/fechasreordersvw", method = RequestMethod.GET)
    public ModelAndView fechasReordersVW(Model model) {
        return getBasicModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/fechasreordersvw", method = RequestMethod.POST)
    public ModelAndView fechasReordersVW(@ModelAttribute Proveedor proveedor) {
        return fechasReordersVWPseudoController.processRequest(getBasicModelAndView(), proveedor);
    }        
    
}
