/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.dtos.core;

import org.springframework.beans.BeanUtils;

/**
 *
 * @author a637201
 */
public abstract class TransformableDto<Translation> {
    
    public abstract Translation translate();
    
    protected Translation translate(Translation translation) {
        BeanUtils.copyProperties(this, translation);
        return translation;
    }
    
}
