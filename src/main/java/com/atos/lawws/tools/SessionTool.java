/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.tools;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 *
 * @author a637201
 */
public class SessionTool {
    
    public static String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    
    public static String getCurrentIpSource() {
        WebAuthenticationDetails authentication = (WebAuthenticationDetails) 
                SecurityContextHolder.getContext().getAuthentication().getDetails();
        return authentication.getRemoteAddress();
    }
    
    public static String getCurrentUserAuthorities() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
    }
    
}
