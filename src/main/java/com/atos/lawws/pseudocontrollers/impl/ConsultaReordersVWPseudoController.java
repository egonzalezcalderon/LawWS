/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.pseudocontrollers.impl;

import com.atos.lawws.bussiness.impl.LawWSListBo;
import com.atos.lawws.bussiness.impl.ProveedorBo;
import com.atos.lawws.bussiness.impl.ReorderProvBo;
import com.atos.lawws.bussiness.impl.ReorderVWBo;
import com.atos.lawws.pseudocontrollers.core.PseudoController;
import com.atos.lawws.services.impl.ConsultaReordersProvService;
import com.atos.lawws.services.impl.ConsultaReordersVWService;
import com.atos.lawws.webservice.xml.consultareordersprov.ReorderProv;
import com.atos.lawws.webservice.xml.consultareordersvw.ReorderVW;
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
public class ConsultaReordersVWPseudoController extends PseudoController<ProveedorBo> {
    
    @Autowired
    ConsultaReordersVWService consultaReordersService;
    
    @Override
    public void fillControllerParameters(ModelAndView model) {
        model.addObject("inputConsultaReordVW", new ProveedorBo());
        model.addObject("reordersVW", new ArrayList<ReorderVWBo>());
        model.addObject("consreordvwact", Boolean.FALSE);
    }

    @Override
    public ModelAndView processRequest(ModelAndView modelAndView, ProveedorBo modelAttribute) {
        LawWSListBo<ReorderVW, ReorderVWBo> reordersVW = consultaReordersService.serve(modelAttribute);
               
        modelAndView.addObject("inputConsultaReordVW", modelAttribute);
        modelAndView.addObject("reordersVW", (reordersVW != null)? reordersVW.getElements():new ArrayList<ReorderVWBo>());
        modelAndView.addObject("consreordvwact", Boolean.TRUE);
        return modelAndView;
    }
    
}
