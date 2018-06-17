/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.controllers.impl;

import com.atos.lawws.bussiness.impl.UserBo;
import com.atos.lawws.bussiness.impl.UserRequestBo;
import com.atos.lawws.bussiness.impl.UserResponseBo;
import com.atos.lawws.services.impl.UserCRUDService;
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
public class UsersController extends LawWSController {
    
    @Autowired
    UserCRUDService userQueryService;
    
    protected ModelAndView getBaseModelAndView(
            UserBo searchUser) {
        ModelAndView mav = getBaseModelAndView("core/users");
        mav.addObject("searchUser", searchUser);
        mav.addObject("newUser", new UserBo());
        mav.addObject("searchUserResult", userQueryService.search(new UserRequestBo(searchUser)).getUsers());
        return mav;
    }
    
    protected ModelAndView getBaseModelAndView() {
        ModelAndView mav = getBaseModelAndView("core/users");
        mav.addObject("searchUser", new UserBo());
        mav.addObject("newUser", new UserBo());
        mav.addObject("searchUserResult", userQueryService.search(new UserRequestBo(new UserBo())).getUsers());
        return mav;
    }     
    
    @RequestMapping(value="/administration/users", method = RequestMethod.GET)
    public ModelAndView users(Model model) {
        return getBaseModelAndView();
    }
    
    @RequestMapping(value="/administration/users", method = RequestMethod.POST)
    public ModelAndView users(@ModelAttribute UserBo userQuery) {
        return getBaseModelAndView(userQuery);
    }
    
    @RequestMapping(value="/administration/users/saveuser", method = RequestMethod.GET)
    public ModelAndView saveUser(Model model) {
        return getBaseModelAndView();  
    }
    
    @RequestMapping(value="/administration/users/saveuser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute UserBo user) {
        UserBo returnedBo = new UserBo();
        UserResponseBo response = (user.getToBeInserted().equals("no"))?
                userQueryService.modify(new UserRequestBo(user)):
                userQueryService.insert(new UserRequestBo(user));
        returnedBo.setValidationResult(response.isOperationCorrect(), response.getOperationResult());
        return getBaseModelAndView(returnedBo);
    }   
    
    @RequestMapping(value="/administration/users/deleteuser", method = RequestMethod.GET)
    public ModelAndView deleteUser(Model model) {
        return getBaseModelAndView();  
    }
    
    @RequestMapping(value="/administration/users/deleteuser", method = RequestMethod.POST)
    public ModelAndView deleteUser(@ModelAttribute UserBo user) {
        userQueryService.delete(new UserRequestBo(user));
        return getBaseModelAndView();
    }        
}
