package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.consrem;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.webservice.xml.consultaremitos.ConsultaRemitosRequest;
import com.atos.lawws.webservice.xml.consultaremitos.ConsultaRemitosResponse;
import com.atos.lawws.webservice.xml.consultaremitos.Remito;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ConsultaRemitosEndpoint {
        
    @PayloadRoot(namespace = webserviceNameSpace+"/"+consrem, localPart = "consultaRemitosRequest")
    @ResponsePayload
    public ConsultaRemitosResponse consultaRemitosRequest(@RequestPayload ConsultaRemitosRequest request) {
        ConsultaRemitosResponse response = new ConsultaRemitosResponse();
        Remito remito1 = new Remito();
        remito1.setCantidad(1);
        remito1.setId(1);
        Remito remito2 = new Remito();
        remito2.setCantidad(1);
        remito2.setId(1);
        response.getRemitos().add(remito1);
        response.getRemitos().add(remito2);

        return response;
    }
}
