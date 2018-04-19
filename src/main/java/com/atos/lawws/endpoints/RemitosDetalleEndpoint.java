package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.remdet;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.webservice.xml.remitosdetalle.DetalleRemito;
import com.atos.lawws.webservice.xml.remitosdetalle.RemitosDetalleRequest;
import com.atos.lawws.webservice.xml.remitosdetalle.RemitosDetalleResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class RemitosDetalleEndpoint {
        
    @PayloadRoot(namespace = webserviceNameSpace+"/"+remdet, localPart = "remitosDetalleRequest")
    @ResponsePayload
    public RemitosDetalleResponse remitosDetalleRequest(@RequestPayload RemitosDetalleRequest request) {
        RemitosDetalleResponse response = new RemitosDetalleResponse();
        DetalleRemito remito1 = new DetalleRemito();
        remito1.setCantidad(1);
        remito1.setKnr("1234");
        DetalleRemito remito2 = new DetalleRemito();
        remito2.setCantidad(1);
        remito2.setKnr("1234");
        response.getRemitosDetalle().add(remito1);
        response.getRemitosDetalle().add(remito2);

        return response;
    }
}
