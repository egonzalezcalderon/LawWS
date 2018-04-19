/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.daos.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.atos.lawws.daos.core.LawWSDao;
import com.atos.lawws.dtos.impl.ReorderVWDto;
import java.util.Date;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author a637201
 */
@Repository
public class ConsultaReordersVWDaoImpl extends LawWSDao {
    
    public List<ReorderVWDto> getVWReorders(String idProveedor, Date fecha) {
        StoredProcedureQuery spQuery = createStoreProcedureQuery("consultaReordersVW");
        spQuery.setParameter("p_idproveedor", idProveedor);
        spQuery.setParameter("p_fecha", fecha);
        return spQuery.getResultList();
    }
}