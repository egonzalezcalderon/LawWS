package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.consreordvw;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.services.impl.ConsultaReordersVWService;
import com.atos.lawws.webservice.xml.consultareordersvw.ConsultaReordersVWRequest;
import com.atos.lawws.webservice.xml.consultareordersvw.ConsultaReordersVWResponse;
import com.atos.lawws.webservice.xml.consultareordersvw.ReorderVW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ConsultaReordersVWEndpoint {
       
    @Autowired
    ConsultaReordersVWService consultaReordersService;
    
    @PayloadRoot(namespace = webserviceNameSpace+"/"+consreordvw, localPart = "consultaReordersVWRequest")
    @ResponsePayload
    public ConsultaReordersVWResponse consultaReordersVWRequest(@RequestPayload ConsultaReordersVWRequest request) {
        ConsultaReordersVWResponse response = new ConsultaReordersVWResponse();
        
        return consultaReordersService.translateResponse(
                consultaReordersService.serve(
                        consultaReordersService.translateRequest(request)
                )
        );
    }
}
