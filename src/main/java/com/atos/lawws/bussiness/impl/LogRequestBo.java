/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.BussinessObject;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author a637201
 */
public class LogRequestBo extends BussinessObject {
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date dateFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date dateTo;

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
