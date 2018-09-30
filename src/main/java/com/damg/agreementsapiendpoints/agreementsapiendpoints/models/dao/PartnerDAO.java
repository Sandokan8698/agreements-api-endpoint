package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.Interfaces.PartnerDAOCustom;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PartnerDAO extends JpaRepository<Partner, Long>, PartnerDAOCustom {
}
