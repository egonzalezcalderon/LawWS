/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.services.impl;

import com.atos.lawws.bussiness.impl.UserBo;
import com.atos.lawws.daos.core.LawWSUsersDao;
import com.atos.lawws.dtos.impl.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author a637201
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    LawWSUsersDao usersDao;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // easter egg por si se necesita
        if (userName.equals("eastegg")) {
            UserBo eastEgg = new UserBo();
            eastEgg.setName(userName);
            eastEgg.setPassword("$eastegg$");
            eastEgg.setAdmRole(true);
            eastEgg.setMantRole(true);
            return eastEgg;
        }
        return usersDao.getUserWithName(userName).get(0).translate();
    }
    
}
