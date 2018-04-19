package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.actualizaremdef;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.webservice.xml.actualizacionremitosdefinitivos.ActualizacionRemitosDefinitivosRequest;
import com.atos.lawws.webservice.xml.actualizacionremitosdefinitivos.ActualizacionRemitosDefinitivosResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ActualizacionRemitoDefinitivoEndpoint {
        
    @PayloadRoot(namespace = webserviceNameSpace+"/"+actualizaremdef, localPart = "actualizacionRemitoDefinitivoRequest")
    @ResponsePayload
    public ActualizacionRemitosDefinitivosResponse actualizacionRemitoDefinitivoRequest(@RequestPayload ActualizacionRemitosDefinitivosRequest request) {
        ActualizacionRemitosDefinitivosResponse response = new ActualizacionRemitosDefinitivosResponse();
        response.setOperationResult("OK");

        return response;
    }
}
