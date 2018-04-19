/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.services.impl;

import com.atos.lawws.bussiness.impl.LawWSInput;
import com.atos.lawws.bussiness.impl.LawWSList;
import com.atos.lawws.bussiness.impl.Proveedor;
import com.atos.lawws.daos.impl.ConsultaCantidadReordersProvDaoImpl;
import com.atos.lawws.dtos.impl.CantidadReorderProvDto;
import com.atos.lawws.services.core.MonitoredService;
import com.atos.lawws.tools.DatesTool;
import com.atos.lawws.webservice.xml.cantidadreordersprov.CantidadReordersProvRequest;
import com.atos.lawws.webservice.xml.cantidadreordersprov.CantidadReordersProvResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a637201
 */
@Service
public class CantidadReordersProvService extends MonitoredService<
        CantidadReordersProvRequest,
        CantidadReordersProvResponse,
        Proveedor,
        LawWSList<Integer, LawWSInput<Integer>>> {

    @Autowired
    ConsultaCantidadReordersProvDaoImpl consultaCantidadReordersDao;
    
    @Override
    protected String getServiceName() {
        return "CantidadReordersProvService";
    }

    @Override
    protected LawWSList monitoredServe(Proveedor request) {
        List<CantidadReorderProvDto> cantidadReorders = consultaCantidadReordersDao.getCantidadReordersProv(request.getId(), request.getFecha());
        LawWSList<Integer, LawWSInput<Integer>> lawwsList = new LawWSList<Integer, LawWSInput<Integer>>();
        
        for (CantidadReorderProvDto cantidadReorder : cantidadReorders) {
            lawwsList.getElements().add(cantidadReorder.translate());
        }
        
        return lawwsList;
    }

    @Override
    public Proveedor translateRequest(CantidadReordersProvRequest extRequest) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(extRequest.getIdproveedor());
        proveedor.setFecha(DatesTool.getDate(extRequest.getFecha()));
        return proveedor;
    }

    @Override
    public CantidadReordersProvResponse translateResponse(LawWSList<Integer, LawWSInput<Integer>> intResponse) {
        CantidadReordersProvResponse cantidadReordersResponse = new CantidadReordersProvResponse();
        
        List<Integer> cantidadReorders = intResponse.translate();
        
        for (Integer cantidadReorder : cantidadReorders) {
            cantidadReordersResponse.getCantidadPie().add(cantidadReorder);
        }
        
        return cantidadReordersResponse;
    }
    
}
