package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="addreses")
public class Address extends BaseEntity {

    @NotNull
    private long account_id;

    @NotNull
    @Size(max = 250)
    private String city;

    @NotNull
    @Size(max = 250)
    private String state;

    @NotNull
    @Size(max = 250)
    private String country;

    private float latitude;
    private float longitude;
    private String primary_address;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PartnerAddresses> partners = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "address",  cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PartnersAgreementsAddresses> partnerAgreements = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "address",  cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AddresesExternalContacts> contacts = new HashSet<>();

    public Address()
    {

    }

    public Address(long account_id, String city, String state, String country) {
        this.account_id = account_id;
        this.city = city;
        this.state = state;
        this.country = country;

    }

    public void addPartner(Partner partner) {
        PartnerAddresses partnerAddresses = new PartnerAddresses(partner, this, account_id);
        partners.add(partnerAddresses);
        partner.getAddresses().add(partnerAddresses);
    }


    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public Set<AddresesExternalContacts> getContacts() {
        return contacts;
    }

    public Set<PartnersAgreementsAddresses> getPartnerAgreements() {
        return partnerAgreements;
    }

}
