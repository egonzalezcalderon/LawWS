/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.TranslatableBussinessObject;

/**
 *
 * @author a637201
 */
public class LawWSInput<Input> extends TranslatableBussinessObject<Input> {
    
    protected Input input;

    public LawWSInput(Input input) {
        this.input = input;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    @Override
    public Input translate() {
        return this.input;
    }
    
}
