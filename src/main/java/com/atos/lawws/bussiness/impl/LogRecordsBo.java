/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.bussiness.impl;

import com.atos.lawws.bussiness.core.BussinessObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a637201
 */
public class LogRecordsBo extends BussinessObject {
    List<LogRecordBo> logRecords = new ArrayList<LogRecordBo>();

    public List<LogRecordBo> getLogRecords() {
        return logRecords;
    }

    public void setLogRecords(List<LogRecordBo> logRecords) {
        this.logRecords = logRecords;
    }
}
