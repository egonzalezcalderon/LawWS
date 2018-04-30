/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.controllers.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author A637201
 */
@Controller
public class MainController {
        
//    @RequestMapping(value="/login", method = RequestMethod.GET)
//    public String login(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "core/login";
//    }
//
//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public ModelAndView login(@ModelAttribute User user) {
//        ModelAndView mav = new ModelAndView("core/login");
//        mav.addObject("user", user);
//        return mav;
//    }  
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String base() {
        return "core/home";
    }
    
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home() {
        return "core/home";
    }   
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "core/login";
    }

    @RequestMapping(value="/error", method = RequestMethod.GET)
    public String error() {
        return "core/error";
    }
    
}
