/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.dtos.impl;

import com.atos.lawws.bussiness.impl.LogRecordBo;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
    protected String userName;
    protected String ipSource;

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

    @Column(name="NOMBRE_USUARIO")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name="IP_ORIGEN")
    public String getIpSource() {
        return ipSource;
    }

    public void setIpSource(String ipSource) {
        this.ipSource = ipSource;
    }
        
    public LogRecordBo retrieveLogRecordBO() {
        LogRecordBo logRecord = new LogRecordBo();
        logRecord.setExecutedMethod(executedMethod);
        logRecord.setRequestMade(requestMade);
        logRecord.setStartDate(startDate);
        logRecord.setStopDate(stopDate);
        logRecord.setStatus(status);
        logRecord.setIpSource(ipSource);
        logRecord.setUserName(userName);
        return logRecord;
    }

}
