package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entities;

import javax.persistence.*;

@Entity
@Table(name="errors")
public class Error extends BaseEntity {

    @Override
    public Long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner_id", nullable = false)
    private Partner partner;
}
