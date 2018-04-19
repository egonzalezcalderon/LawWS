/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author a637201
 */
public class DatesTool {
    
    public static Date getDate(XMLGregorianCalendar date) {
        return date.toGregorianCalendar().getTime();
    }
    
    public static XMLGregorianCalendar getXMLGregorianCalendarDate(Date date) {
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (Exception e) {
            return null;
        }   
    }
    
    public static Date getTodaysDate() {
        return new Date();
    }
    
    public static Date getTomorrowsDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(date); 
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }    
    
    public static Date getDateLowerLimit() {
        try {
            return (new SimpleDateFormat("dd/MM/yyyy")).parse("01/05/2013");
        } catch (Exception e) {
            return new Date();
        }
    }
    
    public static Date getDateUpperLimit() {
        try {
            return (new SimpleDateFormat("dd/MM/yyyy")).parse("15/05/2013");
        } catch (Exception e) {
            return new Date();
        }
    }  
}
