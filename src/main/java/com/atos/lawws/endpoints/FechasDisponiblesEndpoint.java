package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.fecdisp;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.webservice.xml.fechasdisponibles.FechasDisponiblesRequest;
import com.atos.lawws.webservice.xml.fechasdisponibles.FechasDisponiblesResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FechasDisponiblesEndpoint {
        
    @PayloadRoot(namespace = webserviceNameSpace+"/"+fecdisp, localPart = "fechasDisponiblesRequest")
    @ResponsePayload
    public FechasDisponiblesResponse fechasDisponiblesRequest(@RequestPayload FechasDisponiblesRequest request) {
        FechasDisponiblesResponse response = new FechasDisponiblesResponse();
        
        return response;
    }
}
