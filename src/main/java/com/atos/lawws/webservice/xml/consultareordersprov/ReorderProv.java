//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.19 at 08:11:28 PM GFT 
//


package com.atos.lawws.webservice.xml.consultareordersprov;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reorderProv complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reorderProv">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidadPiezas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reorderProv", propOrder = {
    "cantidadPiezas"
})
public class ReorderProv {

    protected int cantidadPiezas;

    /**
     * Gets the value of the cantidadPiezas property.
     * 
     */
    public int getCantidadPiezas() {
        return cantidadPiezas;
    }

    /**
     * Sets the value of the cantidadPiezas property.
     * 
     */
    public void setCantidadPiezas(int value) {
        this.cantidadPiezas = value;
    }

}