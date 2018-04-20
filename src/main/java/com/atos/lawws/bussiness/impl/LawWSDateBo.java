/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.TranslatableBussinessObject;
import com.atos.lawws.tools.DatesTool;
import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author a637201
 */
public class LawWSDateBo extends TranslatableBussinessObject<XMLGregorianCalendar> {
    
    protected Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public XMLGregorianCalendar translate() {
        return DatesTool.getXMLGregorianCalendarDate(date);
    }

}
