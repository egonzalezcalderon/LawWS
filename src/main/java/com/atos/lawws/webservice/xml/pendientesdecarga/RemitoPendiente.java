//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.06 at 02:35:58 PM GFT 
//


package com.atos.lawws.webservice.xml.pendientesdecarga;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for remitoPendiente complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="remitoPendiente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="proveedor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="codRemito" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pieza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="teileart" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="teileartgruppe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "remitoPendiente", propOrder = {
    "proveedor",
    "fecha",
    "codRemito",
    "pieza",
    "cantidad",
    "teileart",
    "teileartgruppe",
    "modelo"
})
public class RemitoPendiente {

    @XmlElement(required = true)
    protected String proveedor;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecha;
    @XmlElement(required = true)
    protected String codRemito;
    @XmlElement(required = true)
    protected String pieza;
    protected int cantidad;
    @XmlElement(required = true)
    protected String teileart;
    @XmlElement(required = true)
    protected String teileartgruppe;
    @XmlElement(required = true)
    protected String modelo;

    /**
     * Gets the value of the proveedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * Sets the value of the proveedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProveedor(String value) {
        this.proveedor = value;
    }

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the codRemito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRemito() {
        return codRemito;
    }

    /**
     * Sets the value of the codRemito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRemito(String value) {
        this.codRemito = value;
    }

    /**
     * Gets the value of the pieza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPieza() {
        return pieza;
    }

    /**
     * Sets the value of the pieza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPieza(String value) {
        this.pieza = value;
    }

    /**
     * Gets the value of the cantidad property.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the teileart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeileart() {
        return teileart;
    }

    /**
     * Sets the value of the teileart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeileart(String value) {
        this.teileart = value;
    }

    /**
     * Gets the value of the teileartgruppe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeileartgruppe() {
        return teileartgruppe;
    }

    /**
     * Sets the value of the teileartgruppe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeileartgruppe(String value) {
        this.teileartgruppe = value;
    }

    /**
     * Gets the value of the modelo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Sets the value of the modelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelo(String value) {
        this.modelo = value;
    }

}