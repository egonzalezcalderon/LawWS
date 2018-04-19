/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.services.impl;

import com.atos.lawws.bussiness.impl.LawWSList;
import com.atos.lawws.bussiness.impl.Proveedor;
import com.atos.lawws.bussiness.impl.ReorderVWBo;
import com.atos.lawws.daos.impl.ConsultaReordersVWDaoImpl;
import com.atos.lawws.dtos.impl.ReorderVWDto;
import com.atos.lawws.services.core.MonitoredService;
import com.atos.lawws.tools.DatesTool;
import com.atos.lawws.webservice.xml.consultareordersvw.ConsultaReordersVWRequest;
import com.atos.lawws.webservice.xml.consultareordersvw.ConsultaReordersVWResponse;
import com.atos.lawws.webservice.xml.consultareordersvw.ReorderVW;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a637201
 */
@Service
public class ConsultaReordersVWService extends MonitoredService<
        ConsultaReordersVWRequest,
        ConsultaReordersVWResponse,
        Proveedor,
        LawWSList<ReorderVW, ReorderVWBo>> {

    @Autowired
    ConsultaReordersVWDaoImpl consultaReordersDao;
    
    @Override
    protected String getServiceName() {
        return "ConsultaReordersVWService";
    }

    @Override
    protected LawWSList monitoredServe(Proveedor request) {
        List<ReorderVWDto> reorders = consultaReordersDao.getVWReorders(request.getId(), request.getFecha());
        LawWSList<ReorderVW, ReorderVWBo> lawwsList = new LawWSList<ReorderVW, ReorderVWBo>();
        
        for (ReorderVWDto reorder : reorders) {
            lawwsList.getElements().add(reorder.translate());
        }
        
        return lawwsList;
    }

    @Override
    public Proveedor translateRequest(ConsultaReordersVWRequest extRequest) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(extRequest.getIdProveedor());
        proveedor.setFecha(DatesTool.getDate(extRequest.getFecha()));
        return proveedor;
    }

    @Override
    public ConsultaReordersVWResponse translateResponse(LawWSList<ReorderVW, ReorderVWBo> intResponse) {
        ConsultaReordersVWResponse consultaReorders = new ConsultaReordersVWResponse();
        
        List<ReorderVW> reorders = intResponse.translate();
        
        for (ReorderVW reorder : reorders) {
            consultaReorders.getReordersVW().add(reorder);
        }
        
        return consultaReorders;
    }
    
}
