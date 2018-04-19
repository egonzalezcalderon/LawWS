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
public class LogRecords extends BussinessObject {
    List<LogRecord> logRecords = new ArrayList<LogRecord>();

    public List<LogRecord> getLogRecords() {
        return logRecords;
    }

    public void setLogRecords(List<LogRecord> logRecords) {
        this.logRecords = logRecords;
    }
}
