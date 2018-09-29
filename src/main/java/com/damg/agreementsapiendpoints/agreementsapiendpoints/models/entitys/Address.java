package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Address extends BaseEntity {

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "addresses")
    private Set<Partner> partners = new HashSet<>();

}
