package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.Implementation;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.Interfaces.PartnerDAOCustom;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

@Repository
@Transactional(readOnly = true)
public class PartnerDAOImpl implements PartnerDAOCustom {

    private static final Logger LOGGER = Logger.getLogger(PartnerDAOCustom.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private PartnerQueryBuilder partnerQueryBuilder;

    @Override
    public List<Partner> getPartnersList(PartnerQueryFilter filter) {

        String sqlCommnand = partnerQueryBuilder.buildSqlCommand(filter);
        Query query = entityManager.createNativeQuery(sqlCommnand);

        return  query.getResultList();
    }

    @Override
    public int getTotalPartners(PartnerQueryFilter filter) {

        String sqlCommnand = partnerQueryBuilder.buildCountCommand(filter);
        Query query = entityManager.createNativeQuery(sqlCommnand);
        return  query.getFirstResult();
    }

    @Override
    public List<Partner> getDebugPartnerList(PartnerQueryFilter filter) {

        String sqlCommnand = partnerQueryBuilder.builDebugCommand(filter);
        Query query = entityManager.createNativeQuery(sqlCommnand);

        return  query.getResultList();
    }
}
