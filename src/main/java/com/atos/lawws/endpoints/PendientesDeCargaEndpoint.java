package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.pendcarg;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.webservice.xml.pendientesdecarga.PendientesDeCargaRequest;
import com.atos.lawws.webservice.xml.pendientesdecarga.PendientesDeCargaResponse;
import com.atos.lawws.webservice.xml.pendientesdecarga.RemitoPendienteDeCarga;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PendientesDeCargaEndpoint {
        
    @PayloadRoot(namespace = webserviceNameSpace+"/"+pendcarg, localPart = "pendientesDeCargaRequest")
    @ResponsePayload
    public PendientesDeCargaResponse pendientesDeCargaRequest(@RequestPayload PendientesDeCargaRequest request) {
        PendientesDeCargaResponse response = new PendientesDeCargaResponse();
        RemitoPendienteDeCarga remito1 = new RemitoPendienteDeCarga();
        remito1.setCantidad(1);
        remito1.setCodRemito("1234");
        RemitoPendienteDeCarga remito2 = new RemitoPendienteDeCarga();
        remito2.setCantidad(1);
        remito2.setCodRemito("1234");
        response.getRemitosPendientesDeCarga().add(remito1);
        response.getRemitosPendientesDeCarga().add(remito2);

        return response;
    }
}
