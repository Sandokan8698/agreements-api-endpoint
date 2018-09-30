package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class QueryBuilderFactory {


    @Autowired
    @Lazy
    private PartnerQueryBuilder partnerQueryBuilder;

    public QueryBuilder createBuilder(QueryBuilderType builderType)
    {
        /*switch (builderType) {
            default:
               return partnerQueryBuilder;
        }*/

        return  null;
    }
}
