package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.Interfaces;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entities.Partner;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryFilter;

import java.util.List;

public interface PartnerDAOCustom {

    List<Partner> getPartnersList(PartnerQueryFilter filter);
    int getTotalPartners(PartnerQueryFilter filter);
    List<Partner> getDebugPartnerList(PartnerQueryFilter filter);
}
