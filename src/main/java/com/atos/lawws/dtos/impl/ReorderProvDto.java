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
	procedureName = "SP_PROV_REORDER_CANTPROV", 
	resultClasses = {ReorderProvDto.class}, 
	parameters = {     
            @StoredProcedureParameter(name="p_idproveedor", type = String.class, mode = ParameterMode.IN),
            @StoredProcedureParameter(name="p_fecha", type = Date.class, mode = ParameterMode.IN),
            @StoredProcedureParameter(name="p_cursor", mode = ParameterMode.REF_CURSOR, type = void.class)
	}
)
public class ReorderProvDto extends TransformableDto<ReorderProvBo> implements Serializable {
    
    protected int cantidadPiezas;
       
    @Id
    @Column(name="cantidadpie")
    public int getCantidadPiezas() {
        return cantidadPiezas;
    }

    public void setCantidadPiezas(int cantidadPiezas) {
        this.cantidadPiezas = cantidadPiezas;
    }   
    
    @Override
    public ReorderProvBo translate() {
        return translate(new ReorderProvBo());
    }    

}