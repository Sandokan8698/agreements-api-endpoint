package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils;

import javax.persistence.Query;

public abstract class QueryBuilder {

    protected QueryFilter filter;
    protected Query query;


    protected abstract Query BuildQuery();

    public Query GetComplexQuery(QueryFilter pFilter)
    {
        this.filter = pFilter;
        return BuildQuery();
    }
}
