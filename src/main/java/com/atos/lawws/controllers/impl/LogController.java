/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.controllers.impl;

import com.atos.lawws.bussiness.impl.LogRecordBo;
import com.atos.lawws.bussiness.impl.LogRequestBo;
import com.atos.lawws.services.impl.LogQueryService;
import com.atos.lawws.tools.DatesTool;
import java.util.ArrayList;
import java.util.List;
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
public class LogController {
    
    @Autowired
    LogQueryService logQueryService;
    
    @RequestMapping(value="/maintenance/log", method = RequestMethod.GET)
    public String queryLog(Model model) {
        LogRequestBo logRequest = new LogRequestBo();
        logRequest.setDateFrom(DatesTool.getTodaysDate());
        logRequest.setDateTo(DatesTool.getTomorrowsDate());
        model.addAttribute("logRequest", logRequest);
        model.addAttribute("logRecords", 
                logQueryService.translateResponse(
                        logQueryService.serve(
                                logQueryService.translateRequest(logRequest))).
                        getLogRecords());
        return "core/log";
    }

    @RequestMapping(value="/maintenance/log", method = RequestMethod.POST)
    public ModelAndView queryLog(@ModelAttribute LogRequestBo logRequest) {
        ModelAndView mav = new ModelAndView("core/log");
        mav.addObject("logRequest", logRequest);
        mav.addObject("logRecords", 
                logQueryService.translateResponse(
                        logQueryService.serve(
                                logQueryService.translateRequest(logRequest))).
                        getLogRecords());
        return mav;
    }       
    
}
