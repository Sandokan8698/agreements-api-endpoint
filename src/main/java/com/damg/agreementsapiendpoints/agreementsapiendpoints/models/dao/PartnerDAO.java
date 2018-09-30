package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.Interfaces.PartnerDAOCustom;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.ExternalContact;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PartnerDAO extends CrudRepository<Partner, Long>, PartnerDAOCustom {

    @Query("SELECT a.id,a.partner_description, a.institution_name, a.partner_website_url FROM Partner a where id = :id AND account_id =  :accountId")
    Set<Partner> getPartnerPreview(@Param("id") Long id, @Param("accountId") Long accountId);

    @Query("SELECT a FROM Partner a where id = :id AND account_id =  :old_accountId")
    Set<Partner> getParnerByAccountAndId(@Param("id") Long id, @Param("old_accountId") Long old_accountId);

}
