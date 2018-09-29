package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.Interfaces.PartnerDAOCustom;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import org.springframework.data.repository.CrudRepository;

public interface PartnerDAO extends CrudRepository<Partner, Long>, PartnerDAOCustom {
}
