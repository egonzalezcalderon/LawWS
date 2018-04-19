package com.atos.lawws.endpoints;

import static com.atos.lawws.config.WebServiceConfig.remagr;
import static com.atos.lawws.config.WebServiceConfig.webserviceNameSpace;
import com.atos.lawws.webservice.xml.remitosagrupado.RemitoAgrupado;
import com.atos.lawws.webservice.xml.remitosagrupado.RemitosAgrupadoRequest;
import com.atos.lawws.webservice.xml.remitosagrupado.RemitosAgrupadoResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class RemitosAgrupadoEndpoint {
        
    @PayloadRoot(namespace = webserviceNameSpace+"/"+remagr, localPart = "remitosAgrupadoRequest")
    @ResponsePayload
    public RemitosAgrupadoResponse remitosAgrupadoRequest(@RequestPayload RemitosAgrupadoRequest request) {
        RemitosAgrupadoResponse response = new RemitosAgrupadoResponse();
        RemitoAgrupado remito1 = new RemitoAgrupado();
        remito1.setCantidad(1);
        remito1.setId(1234);
        RemitoAgrupado remito2 = new RemitoAgrupado();
        remito2.setCantidad(1);
        remito2.setId(1234);
        response.getRemitosAgrupados().add(remito1);
        response.getRemitosAgrupados().add(remito2);

        return response;
    }
}
