//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.19 at 08:11:28 PM GFT 
//


package com.atos.lawws.webservice.xml.remitosdetalle;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="remitosDetalle" type="{http://atos.com/lawws/webservice/xml/remitosdetalle}detalleRemito" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "remitosDetalle"
})
@XmlRootElement(name = "remitosDetalleResponse")
public class RemitosDetalleResponse {

    @XmlElement(required = true)
    protected List<DetalleRemito> remitosDetalle;

    /**
     * Gets the value of the remitosDetalle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remitosDetalle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemitosDetalle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleRemito }
     * 
     * 
     */
    public List<DetalleRemito> getRemitosDetalle() {
        if (remitosDetalle == null) {
            remitosDetalle = new ArrayList<DetalleRemito>();
        }
        return this.remitosDetalle;
    }

}