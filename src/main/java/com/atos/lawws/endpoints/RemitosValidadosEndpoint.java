package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.remval;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.webservice.xml.remitosvalidados.RemitoValidado;
import com.atos.lawws.webservice.xml.remitosvalidados.RemitosValidadosRequest;
import com.atos.lawws.webservice.xml.remitosvalidados.RemitosValidadosResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class RemitosValidadosEndpoint {
        
    @PayloadRoot(namespace = webserviceNameSpace+"/"+remval, localPart = "remitosValidadosRequest")
    @ResponsePayload
    public RemitosValidadosResponse remitosValidadosRequest(@RequestPayload RemitosValidadosRequest request) {
        RemitosValidadosResponse response = new RemitosValidadosResponse();
        RemitoValidado remito1 = new RemitoValidado();
        remito1.setCantidad(1);
        remito1.setCodRemito("1234");
        RemitoValidado remito2 = new RemitoValidado();
        remito2.setCantidad(1);
        remito2.setCodRemito("1234");
        response.getRemitosValidados().add(remito1);
        response.getRemitosValidados().add(remito2);

        return response;
    }
}
