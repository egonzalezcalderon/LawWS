/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.pseudocontrollers.impl;

import com.atos.lawws.bussiness.impl.LawWSDate;
import com.atos.lawws.bussiness.impl.LawWSList;
import com.atos.lawws.bussiness.impl.Proveedor;
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
public class FechasReordersProvPseudoController extends PseudoController<Proveedor> {

    @Autowired
    FechasReordersProvService fechasReordersService;
    
    @Override
    public void fillControllerParameters(ModelAndView model) {
        model.addObject("inputFechasReordProv", new Proveedor());
        model.addObject("fechasReordProv", new ArrayList<Date>());
    }

    @Override
    public ModelAndView processRequest(ModelAndView modelAndView, Proveedor modelAttribute) {
        LawWSList<XMLGregorianCalendar, LawWSDate> fechasReorders = fechasReordersService.serve(modelAttribute);
        List<Date> fechas = new ArrayList<Date>();
        
        for (LawWSDate fecha : fechasReorders.getElements()) {
            fechas.add(fecha.getDate());
        }
        
        modelAndView.addObject("inputFechasReordProv", modelAttribute);
        modelAndView.addObject("fechasReordProv", fechas);
        return modelAndView;
    }
    
}
