package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.*;

@Entity
@Table(name="errors")
public class Error implements IBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Override
    public Long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner_id", nullable = false)
    private Partner partner;
}
