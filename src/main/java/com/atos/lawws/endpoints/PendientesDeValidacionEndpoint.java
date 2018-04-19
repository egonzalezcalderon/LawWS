package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.pendval;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.webservice.xml.pendientesdevalidacion.PendientesDeValidacionRequest;
import com.atos.lawws.webservice.xml.pendientesdevalidacion.PendientesDeValidacionResponse;
import com.atos.lawws.webservice.xml.pendientesdevalidacion.RemitoPendienteDeValidacion;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PendientesDeValidacionEndpoint {
        
    @PayloadRoot(namespace = webserviceNameSpace+"/"+pendval, localPart = "pendientesDeValidacionRequest")
    @ResponsePayload
    public PendientesDeValidacionResponse pendientesDeValidacionRequest(@RequestPayload PendientesDeValidacionRequest request) {
        PendientesDeValidacionResponse response = new PendientesDeValidacionResponse();
        RemitoPendienteDeValidacion remito1 = new RemitoPendienteDeValidacion();
        remito1.setCantidad(1);
        remito1.setModelo("1234");
        RemitoPendienteDeValidacion remito2 = new RemitoPendienteDeValidacion();
        remito2.setCantidad(1);
        remito2.setModelo("1234");
        response.getRemitosPendientesDeValidacion().add(remito1);
        response.getRemitosPendientesDeValidacion().add(remito2);

        return response;
    }
}
