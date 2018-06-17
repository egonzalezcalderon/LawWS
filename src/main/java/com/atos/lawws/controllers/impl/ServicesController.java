/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.controllers.impl;

import com.atos.lawws.bussiness.impl.ProveedorBo;
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
public class ServicesController extends LawWSController {
    
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
      
    protected ModelAndView getBaseModelAndView() {
        ModelAndView basicModelAndView = getBaseModelAndView("core/services");
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
        return getBaseModelAndView();
    }   
     
    @RequestMapping(value="/maintenance/services/cantidadreordersprov", method = RequestMethod.GET)
    public ModelAndView cantidadReordersProv(Model model) {
        return getBaseModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/cantidadreordersprov", method = RequestMethod.POST)
    public ModelAndView cantidadReordersProv(@ModelAttribute ProveedorBo proveedor) {
        return cantidadReordersProvPseudoController.processRequest(getBaseModelAndView(), proveedor);
    }
    
    @RequestMapping(value="/maintenance/services/cantidadreordersvw", method = RequestMethod.GET)
    public ModelAndView cantidadReordersVW(Model model) {
        return getBaseModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/cantidadreordersvw", method = RequestMethod.POST)
    public ModelAndView cantidadReordersVW(@ModelAttribute ProveedorBo proveedor) {
        return cantidadReordersVWPseudoController.processRequest(getBaseModelAndView(), proveedor);
    }

    @RequestMapping(value="/maintenance/services/consultareordersprov", method = RequestMethod.GET)
    public ModelAndView consultaReordersProv(Model model) {
        return getBaseModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/consultareordersprov", method = RequestMethod.POST)
    public ModelAndView consultaReordersProv(@ModelAttribute ProveedorBo proveedor) {
        return consultaReordersProvPseudoController.processRequest(getBaseModelAndView(), proveedor);
    }

    @RequestMapping(value="/maintenance/services/consultareordersvw", method = RequestMethod.GET)
    public ModelAndView consultaReordersVW(Model model) {
        return getBaseModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/consultareordersvw", method = RequestMethod.POST)
    public ModelAndView consultaReordersVW(@ModelAttribute ProveedorBo proveedor) {
        return consultaReordersVWPseudoController.processRequest(getBaseModelAndView(), proveedor);
    }

    @RequestMapping(value="/maintenance/services/fechasreordersprov", method = RequestMethod.GET)
    public ModelAndView fechasReordersProv(Model model) {
        return getBaseModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/fechasreordersprov", method = RequestMethod.POST)
    public ModelAndView fechasReordersProv(@ModelAttribute ProveedorBo proveedor) {
        return fechasReordersProvPseudoController.processRequest(getBaseModelAndView(), proveedor);
    }    
    
    @RequestMapping(value="/maintenance/services/fechasreordersvw", method = RequestMethod.GET)
    public ModelAndView fechasReordersVW(Model model) {
        return getBaseModelAndView();
    }   
    
    @RequestMapping(value="/maintenance/services/fechasreordersvw", method = RequestMethod.POST)
    public ModelAndView fechasReordersVW(@ModelAttribute ProveedorBo proveedor) {
        return fechasReordersVWPseudoController.processRequest(getBaseModelAndView(), proveedor);
    }        
    
}
