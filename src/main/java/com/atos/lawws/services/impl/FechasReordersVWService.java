/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.services.impl;

import com.atos.lawws.bussiness.impl.LawWSDateBo;
import com.atos.lawws.bussiness.impl.LawWSListBo;
import com.atos.lawws.bussiness.impl.ProveedorBo;
import com.atos.lawws.bussiness.impl.ReorderVWBo;
import com.atos.lawws.daos.impl.ConsultaFechasReordersVWDaoImpl;
import com.atos.lawws.daos.impl.ConsultaReordersVWDaoImpl;
import com.atos.lawws.dtos.impl.FechaReorderVWDto;
import com.atos.lawws.dtos.impl.ReorderVWDto;
import com.atos.lawws.services.core.MonitoredService;
import com.atos.lawws.webservice.xml.consultareordersvw.ReorderVW;
import com.atos.lawws.webservice.xml.fechasreordersvw.FechasReordersVWRequest;
import com.atos.lawws.webservice.xml.fechasreordersvw.FechasReordersVWResponse;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a637201
 */
@Service
public class FechasReordersVWService extends MonitoredService<
        FechasReordersVWRequest,
        FechasReordersVWResponse,
        ProveedorBo,
        LawWSListBo<XMLGregorianCalendar, LawWSDateBo>> {

    @Autowired
    ConsultaFechasReordersVWDaoImpl consultaFechasReordersDao;
    
    @Override
    protected String getServiceName() {
        return "FechasReordersVWService";
    }

    @Override
    protected LawWSListBo monitoredServe(ProveedorBo request) {
        List<FechaReorderVWDto> reordersDates = consultaFechasReordersDao.getVWReordersDates(request.getId());
        LawWSListBo<XMLGregorianCalendar, LawWSDateBo> lawwsList = new LawWSListBo<XMLGregorianCalendar, LawWSDateBo>();
        
        for (FechaReorderVWDto reorderDate : reordersDates) {
            lawwsList.getElements().add(reorderDate.translate());
        }
        
        return lawwsList;
    }

    @Override
    public ProveedorBo translateRequest(FechasReordersVWRequest extRequest) {
        ProveedorBo proveedor = new ProveedorBo();
        proveedor.setId(extRequest.getIdproveedor());
        return proveedor;
    }

    @Override
    public FechasReordersVWResponse translateResponse(LawWSListBo<XMLGregorianCalendar, LawWSDateBo> intResponse) {
        FechasReordersVWResponse consultaReorders = new FechasReordersVWResponse();
        
        List<XMLGregorianCalendar> dates = intResponse.translate();
        
        for (XMLGregorianCalendar date : dates) {
            consultaReorders.getFechasReordersVW().add(date);
        }
        
        return consultaReorders;
    }


    
}
