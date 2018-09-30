package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="agreemnents")
public class Agreement extends BaseEntity {

    @NotNull
    private int account_id;

    @Temporal(TemporalType.DATE)
    private Date agreement_start_date;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "agreement", orphanRemoval = true)
    private Set<PartnersAgreementsAddresses> partners = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "agreements_agreementstypes", joinColumns = { @JoinColumn(name = "agreement_type_id") }, inverseJoinColumns = { @JoinColumn(name = "agreement_id") })
    private Set<AgreementType> agreementsTypes = new HashSet<>();

    public Agreement() {
    }

    public Agreement(@NotNull int account_id, Date agreement_start_date) {
        this.account_id = account_id;
        this.agreement_start_date = agreement_start_date;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public Date getAgreement_start_date() {
        return agreement_start_date;
    }

    public void setAgreement_start_date(Date agreement_start_date) {
        this.agreement_start_date = agreement_start_date;
    }

    public Set<PartnersAgreementsAddresses> getPartners() {
        return partners;
    }

    public void setPartners(Set<PartnersAgreementsAddresses> partners) {
        this.partners = partners;
    }

    public Set<AgreementType> getAgreementsTypes() {
        return agreementsTypes;
    }

    public void setAgreementsTypes(Set<AgreementType> agreementsTypes) {
        this.agreementsTypes = agreementsTypes;
    }
}
