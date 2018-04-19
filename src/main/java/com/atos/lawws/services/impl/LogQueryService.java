/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.services.impl;

import com.atos.lawws.bussiness.impl.LogRecords;
import com.atos.lawws.bussiness.impl.LogRequest;
import com.atos.lawws.daos.core.LawWSLogDao;
import com.atos.lawws.dtos.impl.LawWSLogRecordDto;
import com.atos.lawws.services.core.SingleTaskService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a637201
 */
@Service
public class LogQueryService implements SingleTaskService<
        LogRequest,
        LogRecords,
        List<Date>,
        List<LawWSLogRecordDto>> {

    @Autowired
    LawWSLogDao lawWSLogDao;
    
    @Override
    public List<Date> translateRequest(LogRequest extRequest) {
        List<Date> intRequest = new ArrayList<Date>();
        intRequest.add(extRequest.getDateFrom());
        intRequest.add(extRequest.getDateTo());
        return intRequest;
    }

    @Override
    public LogRecords translateResponse(List<LawWSLogRecordDto> intResponse) {
        LogRecords lawWSLogRecords = new LogRecords();
        for (LawWSLogRecordDto logRecord : intResponse) {
            lawWSLogRecords.getLogRecords().add(logRecord.retrieveLogRecordBO());
        }
        return lawWSLogRecords;
    }

    @Override
    public List<LawWSLogRecordDto> serve(List<Date> request) {
        return lawWSLogDao.getLogRecordsBetween(request.get(0), request.get(1));
    }
}
