package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.consreordprov;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.services.impl.ConsultaReordersProvService;
import com.atos.lawws.webservice.xml.consultareordersprov.ConsultaReordersProvRequest;
import com.atos.lawws.webservice.xml.consultareordersprov.ConsultaReordersProvResponse;
import com.atos.lawws.webservice.xml.consultareordersprov.ReorderProv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ConsultaReordersProvEndpoint {
       
    @Autowired
    ConsultaReordersProvService consultaReordersService;
    
    @PayloadRoot(namespace = webserviceNameSpace+"/"+consreordprov, localPart = "consultaReordersProvRequest")
    @ResponsePayload
    public ConsultaReordersProvResponse consultaReordersProvRequest(@RequestPayload ConsultaReordersProvRequest request) {
        ConsultaReordersProvResponse response = new ConsultaReordersProvResponse();
        
        return consultaReordersService.translateResponse(
                consultaReordersService.serve(
                        consultaReordersService.translateRequest(request)
                )
        );
    }
}
