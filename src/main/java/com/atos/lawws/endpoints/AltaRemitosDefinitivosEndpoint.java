package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.altaremdef;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.webservice.xml.altaremitosdefinitivos.AltaRemitosDefinitivosRequest;
import com.atos.lawws.webservice.xml.altaremitosdefinitivos.AltaRemitosDefinitivosResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AltaRemitosDefinitivosEndpoint {
        
    @PayloadRoot(namespace = webserviceNameSpace+"/"+altaremdef, localPart = "altaRemitosDefinitivosRequest")
    @ResponsePayload
    public AltaRemitosDefinitivosResponse altaRemitosDefinitivosRequest(@RequestPayload AltaRemitosDefinitivosRequest request) {
        AltaRemitosDefinitivosResponse response = new AltaRemitosDefinitivosResponse();
        response.setOperationResult("OK");

        return response;
    }
}
