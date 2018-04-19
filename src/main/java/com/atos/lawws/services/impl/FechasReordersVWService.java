/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.services.impl;

import com.atos.lawws.bussiness.impl.LawWSDate;
import com.atos.lawws.bussiness.impl.LawWSList;
import com.atos.lawws.bussiness.impl.Proveedor;
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
        Proveedor,
        LawWSList<XMLGregorianCalendar, LawWSDate>> {

    @Autowired
    ConsultaFechasReordersVWDaoImpl consultaFechasReordersDao;
    
    @Override
    protected String getServiceName() {
        return "FechasReordersVWService";
    }

    @Override
    protected LawWSList monitoredServe(Proveedor request) {
        List<FechaReorderVWDto> reordersDates = consultaFechasReordersDao.getVWReordersDates(request.getId());
        LawWSList<XMLGregorianCalendar, LawWSDate> lawwsList = new LawWSList<XMLGregorianCalendar, LawWSDate>();
        
        for (FechaReorderVWDto reorderDate : reordersDates) {
            lawwsList.getElements().add(reorderDate.translate());
        }
        
        return lawwsList;
    }

    @Override
    public Proveedor translateRequest(FechasReordersVWRequest extRequest) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(extRequest.getIdproveedor());
        return proveedor;
    }

    @Override
    public FechasReordersVWResponse translateResponse(LawWSList<XMLGregorianCalendar, LawWSDate> intResponse) {
        FechasReordersVWResponse consultaReorders = new FechasReordersVWResponse();
        
        List<XMLGregorianCalendar> dates = intResponse.translate();
        
        for (XMLGregorianCalendar date : dates) {
            consultaReorders.getFechasReordersVW().add(date);
        }
        
        return consultaReorders;
    }


    
}
