/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.daos.core;

import com.atos.lawws.dtos.impl.LawWSLogRecordDto;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author a637201
 */
@Repository
public interface LawWSLogDao extends JpaRepository<LawWSLogRecordDto, Integer> {   
    
    @Query("select lr from LawWSLogRecordDto lr where :dateTo >= lr.startDate and lr.startDate >= :dateFrom "
            + "order by lr.startDate desc")
    public List<LawWSLogRecordDto> getLogRecordsBetween(
            @Param("dateFrom") Date dateFrom,
            @Param("dateTo") Date dateTo);
}
