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
import com.atos.lawws.daos.impl.ConsultaFechasReordersProvDaoImpl;
import com.atos.lawws.daos.impl.ConsultaReordersProvDaoImpl;
import com.atos.lawws.daos.impl.ConsultaReordersVWDaoImpl;
import com.atos.lawws.dtos.impl.FechaReorderProvDto;
import com.atos.lawws.dtos.impl.ReorderVWDto;
import com.atos.lawws.services.core.MonitoredService;
import com.atos.lawws.tools.DatesTool;
import com.atos.lawws.webservice.xml.consultareordersvw.ConsultaReordersVWRequest;
import com.atos.lawws.webservice.xml.consultareordersvw.ConsultaReordersVWResponse;
import com.atos.lawws.webservice.xml.consultareordersvw.ReorderVW;
import com.atos.lawws.webservice.xml.fechasreordersprov.FechasReordersProvRequest;
import com.atos.lawws.webservice.xml.fechasreordersprov.FechasReordersProvResponse;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a637201
 */
@Service
public class FechasReordersProvService extends MonitoredService<
        FechasReordersProvRequest,
        FechasReordersProvResponse,
        Proveedor,
        LawWSList<XMLGregorianCalendar, LawWSDate>> {

    @Autowired
    ConsultaFechasReordersProvDaoImpl consultaFechasReordersDao;
    
    @Override
    protected String getServiceName() {
        return "FechasReordersProvService";
    }

    @Override
    protected LawWSList monitoredServe(Proveedor request) {
        List<FechaReorderProvDto> reordersDates = consultaFechasReordersDao.getVWReordersDates(request.getId());
        LawWSList<XMLGregorianCalendar, LawWSDate> lawwsList = new LawWSList<XMLGregorianCalendar, LawWSDate>();
        
        for (FechaReorderProvDto reorderDate : reordersDates) {
            lawwsList.getElements().add(reorderDate.translate());
        }
        
        return lawwsList;
    }

    @Override
    public Proveedor translateRequest(FechasReordersProvRequest extRequest) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(extRequest.getIdProveedor());
        return proveedor;
    }

    @Override
    public FechasReordersProvResponse translateResponse(LawWSList<XMLGregorianCalendar, LawWSDate> intResponse) {
        FechasReordersProvResponse consultaReorders = new FechasReordersProvResponse();
        
        List<XMLGregorianCalendar> dates = intResponse.translate();
        
        for (XMLGregorianCalendar date : dates) {
            consultaReorders.getFechasReordersProv().add(date);
        }
        
        return consultaReorders;
    }
}
