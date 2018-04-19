/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.pseudocontrollers.impl;

import com.atos.lawws.bussiness.impl.LawWSInput;
import com.atos.lawws.bussiness.impl.LawWSList;
import com.atos.lawws.bussiness.impl.Proveedor;
import com.atos.lawws.pseudocontrollers.core.PseudoController;
import com.atos.lawws.services.impl.CantidadReordersProvService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author a637201
 */
@Service
public class CantidadReordersProvPseudoController extends PseudoController<Proveedor> {

    @Autowired
    CantidadReordersProvService cantidadReordersService;
    
    @Override
    public void fillControllerParameters(ModelAndView model) {
        model.addObject("inputCantReordProv", new Proveedor());
        model.addObject("cantReordProv", new ArrayList<Integer>());
    }

    @Override
    public ModelAndView processRequest(ModelAndView modelAndView, Proveedor modelAttribute) {
        LawWSList<Integer, LawWSInput<Integer>> cantidadReorders = cantidadReordersService.serve(modelAttribute);
        modelAndView.addObject("inputCantReordProv", modelAttribute);
        modelAndView.addObject("cantReordProv", cantidadReorders.translate());
        return modelAndView;
    }
    
}
