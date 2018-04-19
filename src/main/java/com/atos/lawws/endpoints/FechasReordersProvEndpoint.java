package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.fecreordprov;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.services.impl.FechasReordersProvService;
import com.atos.lawws.webservice.xml.fechasreordersprov.FechasReordersProvRequest;
import com.atos.lawws.webservice.xml.fechasreordersprov.FechasReordersProvResponse;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FechasReordersProvEndpoint {
        
    @Autowired
    FechasReordersProvService fechasReordersService;
    
    @PayloadRoot(namespace = webserviceNameSpace+"/"+fecreordprov, localPart = "fechasReordersProvRequest")
    @ResponsePayload
    public FechasReordersProvResponse fechasReordersProvRequest(@RequestPayload FechasReordersProvRequest request) {
        FechasReordersProvRequest response = new FechasReordersProvRequest();
        
        return fechasReordersService.translateResponse(
                fechasReordersService.serve(
                        fechasReordersService.translateRequest(request)
                )
        );
    }
}
