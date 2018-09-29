package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.Implementation;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.Interfaces.PartnerDAOCustom;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryBuilder;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryFilter;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.QueryBuilderFactory;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.QueryBuilderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
@Transactional(readOnly = true)
public class PartnerDAOImpl implements PartnerDAOCustom {

    private static final Logger LOGGER = Logger.getLogger(PartnerDAOCustom.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private QueryBuilderFactory builderFactory;

    @Override
    public List<Partner> getPartnersList(PartnerQueryFilter filter) {

        LOGGER.info("Logger Name: "+LOGGER.getName());

        PartnerQueryBuilder partnerQueryBuilder = (PartnerQueryBuilder) builderFactory.createBuilder(QueryBuilderType.PartnerBuilder);

        Query query = entityManager.createNativeQuery(partnerQueryBuilder.GetComplexQuery(filter).toString());

        return  query.getResultList();
    }
}
