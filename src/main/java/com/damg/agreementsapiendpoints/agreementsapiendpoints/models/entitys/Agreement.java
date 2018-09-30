package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="agreemnents")
public class Agreement implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    private int account_id;
    private Date agreement_start_date;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "agreement")
    private Set<PartnersAgreementsAddresses> partners;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "agreements_agreementstypes", joinColumns = { @JoinColumn(name = "agreement_type_id") }, inverseJoinColumns = { @JoinColumn(name = "agreement_id") })
    private Set<AgreementType> agreementsTypes;


    @Override
    public Long getId() {
        return id;
    }
}
