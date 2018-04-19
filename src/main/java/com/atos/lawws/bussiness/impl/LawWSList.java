/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.BussinessObject;
import com.atos.lawws.bussiness.core.TranslatableBussinessObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a637201
 */
public class LawWSList<Translation, Element extends TranslatableBussinessObject<Translation>> extends BussinessObject {
    List<Element> elements = new ArrayList<Element>();

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public List<Translation> translate() {
        List<Translation> translatedList = new ArrayList<Translation>();
        for (Element element : elements) {
            translatedList.add(element.translate());
        }        
        return translatedList;
    }
         
}
