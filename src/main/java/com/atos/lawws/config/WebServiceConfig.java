package com.atos.lawws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    
    // WebService General Config
    public static final String webserviceContextPath = "/services";
    public static final String webserviceNameSpace = "http://atos.com/lawws/webservice/xml";
    public static final String webserviceRequestName = "Request";
    
    // WebServices Names
    public static final String remval = "remitosvalidados";
    public static final String remdet = "remitosdetalle";
    public static final String remagr = "remitosagrupado";
    public static final String pendval = "pendientesdevalidacion";
    public static final String pendcarg = "pendientesdecarga";
    public static final String fecreordvw = "fechasreordersvw";
    public static final String fecreordprov = "fechasreordersprov";
    public static final String fecdisp = "fechasdisponibles";
    public static final String consreordvw = "consultareordersvw";
    public static final String consreordprov = "consultareordersprov";
    public static final String consrem = "consultaremitos";
    public static final String cantreordvw = "cantidadreordersvw";
    public static final String cantreordprov = "cantidadreordersprov";
    public static final String cantrem = "cantidadremitos";
    public static final String altaremdef = "altaremitosdefinitivos";
    public static final String actualizaremdef = "actualizacionremitodefinitivo";    
    
    // Schema Beans
    @Bean public XsdSchema remvalSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/remitosvalidados.xsd"));}    
    @Bean public XsdSchema remdetSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/remitosdetalle.xsd"));}       
    @Bean public XsdSchema remagrSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/remitosagrupado.xsd"));}           
    @Bean public XsdSchema pendvalSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/pendientesdevalidacion.xsd"));}     
    @Bean public XsdSchema pendcargSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/pendientesdecarga.xsd"));}    
    @Bean public XsdSchema fecreordvwSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/fechasreordersvw.xsd"));}     
    @Bean public XsdSchema fecreordprovSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/fechasreordersprov.xsd"));}        
    @Bean public XsdSchema fecdispSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/fechasdisponibles.xsd"));} 
    @Bean public XsdSchema consreordvwSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/consultareordersvw.xsd"));} 
    @Bean public XsdSchema consreordprovSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/consultareordersprov.xsd"));}
    @Bean public XsdSchema consremSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/consultaremitos.xsd"));}
    @Bean public XsdSchema cantreordvwSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/cantidadreordersvw.xsd"));}
    @Bean public XsdSchema cantreordprovSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/cantidadreordersprov.xsd"));}
    @Bean public XsdSchema cantremSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/cantidadremitos.xsd"));}
    @Bean public XsdSchema altaremdefSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/altaremitosdefinitivos.xsd"));}
    @Bean public XsdSchema actualizaremdefSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/actualizacionremitodefinitivo.xsd"));}    
    
    @Bean public XsdSchema employeesSchema() {return new SimpleXsdSchema(new ClassPathResource("/schemas/employees.xsd"));}        
    
    @Autowired
    protected Environment environment;
    
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, webserviceContextPath+"/*");
    }

    //WSDL Beans
    
    @Bean(name = remval)
    public DefaultWsdl11Definition remvalWsdl11Definition(XsdSchema remvalSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(remval);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+remval);
        wsdl11Definition.setSchema(remvalSchema);
        return wsdl11Definition;
    } 
    
    @Bean(name = remdet)
    public DefaultWsdl11Definition remdetWsdl11Definition(XsdSchema remdetSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(remdet);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+remdet);
        wsdl11Definition.setSchema(remdetSchema);
        return wsdl11Definition;
    }

    @Bean(name = remagr)
    public DefaultWsdl11Definition remagrWsdl11Definition(XsdSchema remagrSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(remagr);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+remagr);
        wsdl11Definition.setSchema(remagrSchema);
        return wsdl11Definition;
    }

    @Bean(name = pendval)
    public DefaultWsdl11Definition pendvalWsdl11Definition(XsdSchema pendvalSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(pendval);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+pendval);
        wsdl11Definition.setSchema(pendvalSchema);
        return wsdl11Definition;
    }

    @Bean(name = pendcarg)
    public DefaultWsdl11Definition pendcargWsdl11Definition(XsdSchema pendcargSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(pendcarg);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+pendcarg);
        wsdl11Definition.setSchema(pendcargSchema);
        return wsdl11Definition;
    }

    @Bean(name = fecreordvw)
    public DefaultWsdl11Definition fecreordvwWsdl11Definition(XsdSchema fecreordvwSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(fecreordvw);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+fecreordvw);
        wsdl11Definition.setSchema(fecreordvwSchema);
        return wsdl11Definition;
    }

    @Bean(name = fecreordprov)
    public DefaultWsdl11Definition fecreordprovWsdl11Definition(XsdSchema fecreordprovSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(fecreordprov);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+fecreordprov);
        wsdl11Definition.setSchema(fecreordprovSchema);
        return wsdl11Definition;
    }

    @Bean(name = fecdisp)
    public DefaultWsdl11Definition fecdispWsdl11Definition(XsdSchema fecdispSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(fecdisp);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+fecdisp);
        wsdl11Definition.setSchema(fecdispSchema);
        return wsdl11Definition;
    }

    @Bean(name = consreordvw)
    public DefaultWsdl11Definition consreordvwWsdl11Definition(XsdSchema consreordvwSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(consreordvw);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+consreordvw);
        wsdl11Definition.setSchema(consreordvwSchema);
        return wsdl11Definition;
    }

    @Bean(name = consreordprov)
    public DefaultWsdl11Definition consreordprovWsdl11Definition(XsdSchema consreordprovSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(consreordprov);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+consreordprov);
        wsdl11Definition.setSchema(consreordprovSchema);
        return wsdl11Definition;
    }
    
    @Bean(name = consrem)
    public DefaultWsdl11Definition consremWsdl11Definition(XsdSchema consremSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(consrem);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+consrem);
        wsdl11Definition.setSchema(consremSchema);
        return wsdl11Definition;
    }    
    
    @Bean(name = cantreordvw)
    public DefaultWsdl11Definition cantreordvwWsdl11Definition(XsdSchema cantreordvwSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(cantreordvw);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+cantreordvw);
        wsdl11Definition.setSchema(cantreordvwSchema);
        return wsdl11Definition;
    }    
    
    @Bean(name = cantreordprov)
    public DefaultWsdl11Definition cantreordprovWsdl11Definition(XsdSchema cantreordprovSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(cantreordprov);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+cantreordprov);
        wsdl11Definition.setSchema(cantreordprovSchema);
        return wsdl11Definition;
    }       

    @Bean(name = cantrem)
    public DefaultWsdl11Definition cantremWsdl11Definition(XsdSchema cantremSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(cantrem);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+cantrem);
        wsdl11Definition.setSchema(cantremSchema);
        return wsdl11Definition;
    }

    @Bean(name = altaremdef)
    public DefaultWsdl11Definition altaremdefWsdl11Definition(XsdSchema altaremdefSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(altaremdef);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+altaremdef);
        wsdl11Definition.setSchema(altaremdefSchema);
        return wsdl11Definition;
    }

    @Bean(name = actualizaremdef)
    public DefaultWsdl11Definition actualizaremdefWsdl11Definition(XsdSchema actualizaremdefSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(actualizaremdef);
        wsdl11Definition.setLocationUri(webserviceContextPath);
        wsdl11Definition.setTargetNamespace(webserviceNameSpace+"/"+actualizaremdef);
        wsdl11Definition.setSchema(actualizaremdefSchema);
        return wsdl11Definition;
    }
    
    @Bean(name = "employees")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema employeesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EmployeePort");
        wsdl11Definition.setLocationUri("/services");
        wsdl11Definition.setTargetNamespace("http://atos.com/lawws/webservice/xml");
        wsdl11Definition.setSchema(employeesSchema);
        return wsdl11Definition;
    }
}
