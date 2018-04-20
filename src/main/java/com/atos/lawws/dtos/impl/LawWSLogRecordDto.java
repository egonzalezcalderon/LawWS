/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.dtos.impl;

import com.atos.lawws.bussiness.impl.LawWSLogRecordBo;
import com.atos.lawws.bussiness.impl.LogRecordBo;
import com.atos.lawws.bussiness.impl.ReorderVWBo;
import com.atos.lawws.dtos.core.TransformableDto;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author a637201
 */
@Entity
@Table(name = "WEB_SERVICE_LOG")
public class LawWSLogRecordDto{
        
    protected Integer id;
    protected String executedMethod;
    protected String requestMade;
    protected Date startDate;
    protected Date stopDate;
    protected String status;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WEB_SERVICE_LOG_SEQ")
    @SequenceGenerator(name = "WEB_SERVICE_LOG_SEQ", sequenceName = "WEB_SERVICE_LOG_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name="ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="METODO")
    public String getExecutedMethod() {
        return executedMethod;
    }

    public void setExecutedMethod(String executedMethod) {
        this.executedMethod = executedMethod;
    }

    @Column(name="WS_CALL")
    public String getRequestMade() {
        return requestMade;
    }

    public void setRequestMade(String requestMade) {
        this.requestMade = requestMade;
    }

    @Column(name="FECHA_CALL")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name="FECHA_RESPONSE")
    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }
    
    @Column(name="ESTADO")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public LogRecordBo retrieveLogRecordBO() {
        LogRecordBo logRecord = new LogRecordBo();
        logRecord.setExecutedMethod(executedMethod);
        logRecord.setRequestMade(requestMade);
        logRecord.setStartDate(startDate);
        logRecord.setStopDate(stopDate);
        logRecord.setStatus(status);
        return logRecord;
    }

}
