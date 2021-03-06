/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.services.core;

import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author a637201
 */
@Service
public interface SingleTaskService<ExtRequest, ExtResponse, IntRequest, IntResponse> {
    
    public IntRequest translateRequest(ExtRequest extRequest);
    
    public ExtResponse translateResponse(IntResponse intResponse);
    
    public IntResponse serve(IntRequest request);
    
}
