package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="agreemntes_types")
public class AgreementType implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "agreementsTypes")
    private Set<Agreement> agreements;

    @Override
    public Long getId() {
        return id;
    }
}
