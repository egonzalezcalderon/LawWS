package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.cantrem;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.webservice.xml.cantidadremitos.CantidadRemitosRequest;
import com.atos.lawws.webservice.xml.cantidadremitos.CantidadRemitosResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CantidadRemitosEndpoint {
        
    @PayloadRoot(namespace = webserviceNameSpace+"/"+cantrem, localPart = "cantidadRemitosRequest")
    @ResponsePayload
    public CantidadRemitosResponse cantidadRemitosRequest(@RequestPayload CantidadRemitosRequest request) {
        CantidadRemitosResponse response = new CantidadRemitosResponse();
        response.setCantidadPiezas(1);
        response.setCantidadRemitos(2);

        return response;
    }
}
