package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils;

import java.util.HashMap;
import java.util.Objects;

public class ComplexQuery {

    private String query;
    private HashMap<Object, Object> parameters;

    public ComplexQuery() {
        query = "";
        parameters = new HashMap<>();
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public HashMap<Object, Object> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<Object, Object> parameters) {
        this.parameters = parameters;
    }
}
