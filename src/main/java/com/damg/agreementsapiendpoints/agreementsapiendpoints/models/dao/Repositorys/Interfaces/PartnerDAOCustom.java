package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.Interfaces;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryFilter;

import java.util.List;

public interface PartnerDAOCustom {

    List<Partner> getPartnersList(PartnerQueryFilter filter);
}
