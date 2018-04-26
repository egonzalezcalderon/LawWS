/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.pseudocontrollers.impl;

import com.atos.lawws.bussiness.impl.LawWSDateBo;
import com.atos.lawws.bussiness.impl.LawWSListBo;
import com.atos.lawws.bussiness.impl.ProveedorBo;
import com.atos.lawws.pseudocontrollers.core.PseudoController;
import com.atos.lawws.services.impl.FechasReordersProvService;
import com.atos.lawws.services.impl.FechasReordersVWService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author a637201
 */
@Service
public class FechasReordersProvPseudoController extends PseudoController<ProveedorBo> {

    @Autowired
    FechasReordersProvService fechasReordersService;
    
    @Override
    public void fillControllerParameters(ModelAndView model) {
        model.addObject("inputFechasReordProv", new ProveedorBo());
        model.addObject("fechasReordProv", new ArrayList<Date>());
        model.addObject("fecreordprovact", Boolean.FALSE);
    }

    @Override
    public ModelAndView processRequest(ModelAndView modelAndView, ProveedorBo modelAttribute) {
        LawWSListBo<XMLGregorianCalendar, LawWSDateBo> fechasReorders = fechasReordersService.serve(modelAttribute);
        List<Date> fechas = new ArrayList<Date>();
        
        for (LawWSDateBo fecha : fechasReorders.getElements()) {
            fechas.add(fecha.getDate());
        }
        
        modelAndView.addObject("inputFechasReordProv", modelAttribute);
        modelAndView.addObject("fechasReordProv", fechas);
        modelAndView.addObject("fecreordprovact", Boolean.TRUE);
        return modelAndView;
    }
    
}
