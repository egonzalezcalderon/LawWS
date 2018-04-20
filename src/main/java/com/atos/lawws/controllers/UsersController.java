/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.controllers;

import com.atos.lawws.bussiness.impl.LogRequestBo;
import com.atos.lawws.bussiness.impl.UserBo;
import com.atos.lawws.bussiness.impl.UserRequestBo;
import com.atos.lawws.services.impl.UserCRUDService;
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
public class UsersController {
    
    @Autowired
    UserCRUDService userQueryService;
    
    protected ModelAndView getUsersModelAndView(
            UserBo searchUser, 
            List<UserBo> searchUserResult,
            UserBo newUser, 
            UserBo alterUser) {
        ModelAndView mav = new ModelAndView("core/users");
        mav.addObject("searchUser", searchUser);
        mav.addObject("newUser", newUser);
        mav.addObject("alterUser", alterUser);
        mav.addObject("searchUserResult", searchUserResult);
        return mav;
    } 
    
    @RequestMapping(value="/administration/users", method = RequestMethod.GET)
    public ModelAndView users(Model model) {
        return getUsersModelAndView(
                new UserBo(), 
                new ArrayList<UserBo>(),
                new UserBo(), 
                new UserBo());
    }
    
    @RequestMapping(value="/administration/users", method = RequestMethod.POST)
    public ModelAndView users(@ModelAttribute UserBo userQuery) {
        return getUsersModelAndView(
                userQuery, 
                userQueryService.serve(new UserRequestBo(userQuery, true, false)).getUsers(),
                new UserBo(), 
                new UserBo());
    }
    
    @RequestMapping(value="/administration/users/saveuser", method = RequestMethod.GET)
    public ModelAndView saveUser(Model model) {
        return getUsersModelAndView(
                new UserBo(), 
                new ArrayList<UserBo>(),
                new UserBo(), 
                new UserBo());  
    }
    
    @RequestMapping(value="/administration/users/saveuser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute UserBo user) {
        return getUsersModelAndView(
                user, 
                userQueryService.serve(new UserRequestBo(user, false, false)).getUsers(),
                new UserBo(), 
                new UserBo());
    }    
    
}
