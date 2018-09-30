package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class QueryBuilder {

    protected ComplexQuery query;

    protected abstract ComplexQuery buildQuery();
    protected abstract void setFilter(QueryFilter pFilter);

    public ComplexQuery GetComplexQuery(QueryFilter pFilter)
    {
        query = new ComplexQuery();
        this.setFilter(pFilter);
        return buildQuery();
    }
}
