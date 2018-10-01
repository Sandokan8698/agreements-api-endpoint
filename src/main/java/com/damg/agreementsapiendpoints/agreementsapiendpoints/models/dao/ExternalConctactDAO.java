package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entities.ExternalContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ExternalConctactDAO extends JpaRepository<ExternalContact, Long> {

    @Query("SELECT a FROM ExternalContact a where id = :id AND account_id =  :old_accountId")
    Set<ExternalContact> getExternalContactByAccountAndId(@Param("id") Long id, @Param("old_accountId") Long old_accountId);
}
