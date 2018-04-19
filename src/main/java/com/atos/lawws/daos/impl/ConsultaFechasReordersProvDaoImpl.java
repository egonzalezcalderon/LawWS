/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.daos.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.atos.lawws.daos.core.LawWSDao;
import com.atos.lawws.dtos.impl.FechaReorderProvDto;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author a637201
 */
@Repository
public class ConsultaFechasReordersProvDaoImpl extends LawWSDao {
    
    public List<FechaReorderProvDto> getVWReordersDates(String idProveedor) {
        StoredProcedureQuery spQuery = createStoreProcedureQuery("consultaFechasReordersProv");
        spQuery.setParameter("p_idproveedor", idProveedor);
        return spQuery.getResultList();
    }
}