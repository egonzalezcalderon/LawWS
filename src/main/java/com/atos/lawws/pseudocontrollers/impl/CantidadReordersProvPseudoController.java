/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.pseudocontrollers.impl;

import com.atos.lawws.bussiness.impl.LawWSInputBo;
import com.atos.lawws.bussiness.impl.LawWSListBo;
import com.atos.lawws.bussiness.impl.ProveedorBo;
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
public class CantidadReordersProvPseudoController extends PseudoController<ProveedorBo> {

    @Autowired
    CantidadReordersProvService cantidadReordersService;
    
    @Override
    public void fillControllerParameters(ModelAndView model) {
        model.addObject("inputCantReordProv", new ProveedorBo());
        model.addObject("cantReordProv", new ArrayList<Integer>());
    }

    @Override
    public ModelAndView processRequest(ModelAndView modelAndView, ProveedorBo modelAttribute) {
        LawWSListBo<Integer, LawWSInputBo<Integer>> cantidadReorders = cantidadReordersService.serve(modelAttribute);
        modelAndView.addObject("inputCantReordProv", modelAttribute);
        modelAndView.addObject("cantReordProv", cantidadReorders.translate());
        return modelAndView;
    }
    
}
