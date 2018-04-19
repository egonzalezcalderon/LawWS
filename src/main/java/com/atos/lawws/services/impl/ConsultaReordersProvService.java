/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.services.impl;

import com.atos.lawws.bussiness.impl.LawWSList;
import com.atos.lawws.bussiness.impl.Proveedor;
import com.atos.lawws.bussiness.impl.ReorderProvBo;
import com.atos.lawws.daos.impl.ConsultaReordersProvDaoImpl;
import com.atos.lawws.dtos.impl.ReorderProvDto;
import com.atos.lawws.services.core.MonitoredService;
import com.atos.lawws.tools.DatesTool;
import com.atos.lawws.webservice.xml.consultareordersprov.ConsultaReordersProvRequest;
import com.atos.lawws.webservice.xml.consultareordersprov.ConsultaReordersProvResponse;
import com.atos.lawws.webservice.xml.consultareordersprov.ReorderProv;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a637201
 */
@Service
public class ConsultaReordersProvService extends MonitoredService<
        ConsultaReordersProvRequest,
        ConsultaReordersProvResponse,
        Proveedor,
        LawWSList<ReorderProv, ReorderProvBo>> {

    @Autowired
    ConsultaReordersProvDaoImpl consultaReordersDao;
    
    @Override
    protected String getServiceName() {
        return "ConsultaReordersProvService";
    }

    @Override
    protected LawWSList monitoredServe(Proveedor request) {
        List<ReorderProvDto> reorders = consultaReordersDao.getProvReorders(request.getId(), request.getFecha());
        LawWSList<ReorderProv, ReorderProvBo> lawwsList = new LawWSList<ReorderProv, ReorderProvBo>();
        
        for (ReorderProvDto reorder : reorders) {
            lawwsList.getElements().add(reorder.translate());
        }
        
        return lawwsList;
    }

    @Override
    public Proveedor translateRequest(ConsultaReordersProvRequest extRequest) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(extRequest.getIdProveedor());
        proveedor.setFecha(DatesTool.getDate(extRequest.getFecha()));
        return proveedor;
    }

    @Override
    public ConsultaReordersProvResponse translateResponse(LawWSList<ReorderProv, ReorderProvBo> intResponse) {
        ConsultaReordersProvResponse consultaReorders = new ConsultaReordersProvResponse();
        
        List<ReorderProv> reorders = intResponse.translate();
        
        for (ReorderProv reorder : reorders) {
            consultaReorders.getReordersProv().add(reorder);
        }
        
        return consultaReorders;
    }
    
}
