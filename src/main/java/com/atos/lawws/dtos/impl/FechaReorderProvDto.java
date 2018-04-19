/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.dtos.impl;

import com.atos.lawws.bussiness.impl.LawWSDate;
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
	name = "consultaFechasReordersProv", 
	procedureName = "SP_PROV_REORDER_FECPROV", 
	resultClasses = {FechaReorderProvDto.class}, 
	parameters = {     
            @StoredProcedureParameter(name="p_idproveedor", type = String.class, mode = ParameterMode.IN),
            @StoredProcedureParameter(name="p_cursor", mode = ParameterMode.REF_CURSOR, type = void.class)
	}
)
public class FechaReorderProvDto extends TransformableDto<LawWSDate> implements Serializable {
    
    protected Date date;
       
    @Id
    @Column(name="fecha")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public LawWSDate translate() {
        return translate(new LawWSDate());
    }    

}