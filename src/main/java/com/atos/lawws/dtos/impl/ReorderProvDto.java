/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.dtos.impl;

import com.atos.lawws.bussiness.impl.ReorderProvBo;
import com.atos.lawws.dtos.core.TransformableDto;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 *
 * @author a637201
 */
@Entity
@NamedStoredProcedureQuery(
	name = "consultaReordersProv", 
	procedureName = "SP_PROV_REORDER_SELPROV", 
	resultClasses = {ReorderProvDto.class}, 
	parameters = {     
            @StoredProcedureParameter(name="p_idproveedor", type = String.class, mode = ParameterMode.IN),
            @StoredProcedureParameter(name="p_fecha", type = Date.class, mode = ParameterMode.IN),
            @StoredProcedureParameter(name="p_cursor", mode = ParameterMode.REF_CURSOR, type = void.class)
	}
)
public class ReorderProvDto extends TransformableDto<ReorderProvBo> implements Serializable {
    
        protected String codPluma;
    protected String pieza;
    protected int cantidad;
    protected Date fechaImportacion;

    @Id
    @Column(name="codpluma")
    public String getCodPluma() {
        return codPluma;
    }

    public void setCodPluma(String codPluma) {
        this.codPluma = codPluma;
    }
    
    @Id
    @Column(name="pieza")
    public String getPieza() {
        return pieza;
    }

    public void setPieza(String pieza) {
        this.pieza = pieza;
    }
    
    @Id
    @Column(name="cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Id
    @Column(name="fechaimportacion")
    public Date getFechaImportacion() {
        return fechaImportacion;
    }

    public void setFechaImportacion(Date fechaImportacion) {
        this.fechaImportacion = fechaImportacion;
    } 
    
    @Override
    public ReorderProvBo translate() {
        ReorderProvBo reorder = translate(new ReorderProvBo());
        
        try {
            reorder.setFechaImp(fechaImportacion);
        } catch (Exception ex) {
            reorder.setFechaImp(null);
        }
        
        return reorder;
    }    

}