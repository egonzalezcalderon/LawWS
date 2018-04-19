/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.daos.core;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author a637201
 */
public abstract class LawWSDao {

    @PersistenceContext
    EntityManager entityManager;    
    
    protected StoredProcedureQuery createStoreProcedureQuery(String storeProcedureName) {
        return entityManager.createNamedStoredProcedureQuery(storeProcedureName);
    }
    
}
