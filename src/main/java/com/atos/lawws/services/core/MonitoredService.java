/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.services.core;

import com.atos.lawws.bussiness.core.BussinessObject;
import com.atos.lawws.bussiness.impl.LawWSLogRecordBo;
import com.atos.lawws.daos.core.LawWSLogDao;
import java.util.Date;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author a637201
 */
public abstract class MonitoredService
        <ExtRequest,
        ExtResponse,
        IntRequest extends BussinessObject, 
        IntResponse extends BussinessObject> 
        implements SingleTaskService<ExtRequest, ExtResponse, IntRequest, IntResponse> {
    
    @Autowired
    protected LawWSLogDao lawWSLogDao;
    
    protected Logger logger = Logger.getLogger(this.getClass());
   
    protected abstract String getServiceName();

    protected abstract IntResponse monitoredServe(IntRequest request) throws Exception;

    protected LawWSLogRecordBo<IntRequest,IntResponse> logRecord = new LawWSLogRecordBo<IntRequest,IntResponse>();
        
    protected void logServiceExecution() {
        this.logger.info(logRecord.serialize());
        try { 
            lawWSLogDao.save(logRecord.getLogRecordDto());
        } catch (Exception e) {
            this.logger.error(
                "Ocurrio un error intentando persistir en Log de la Base de Datos. Detalle: "+
                        ExceptionUtils.getRootCauseMessage(e));
        }
    }
    
    @Override 
    public IntResponse serve(IntRequest request) {
        logRecord.setServiceName(getServiceName());
        logRecord.setStartDate(new Date());
        logRecord.setRequest(request);
        IntResponse response = null;
        
        try {
            response = monitoredServe(request);
            logRecord.setStatus("Ejecucion OK");
        } catch (Exception e) {
            logRecord.setStatus("Ejecucion Error. Detalle: "+ExceptionUtils.getRootCauseMessage(e));
        }
        logRecord.setResponse(response);
        logRecord.setStopDate(new Date());
        logServiceExecution();
        return logRecord.getResponse();
    }
    
    
}
