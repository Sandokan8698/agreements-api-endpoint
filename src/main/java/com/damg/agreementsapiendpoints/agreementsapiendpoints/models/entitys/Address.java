package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Iterator;
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
    private Set<PartnersAgreementsAddresses> agreements = new HashSet<>();

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

    public Set<PartnerAddresses> getPartners() {
        return partners;
    }

    public void setPartners(PartnerAddresses partner) {
        this.partners.add(partner);
    }

    public void addPartner(Partner partner) {
        PartnerAddresses partnerAddresses = new PartnerAddresses(partner, this, account_id);
        partners.add(partnerAddresses);
        partner.getAddresses().add(partnerAddresses);
    }

    public void removePartner(Partner partner) {

        for (Iterator<PartnerAddresses> iterator = partners.iterator();
             iterator.hasNext(); ) {
             PartnerAddresses partnerAddresses = iterator.next();

            if (partnerAddresses.getAddress().equals(this) &&  partnerAddresses.getPartner().equals(partner)) {
                iterator.remove();
                partnerAddresses.getPartner().getAddresses().remove(partnerAddresses);
                partnerAddresses.setAddress(null);
                partnerAddresses.setPartner(null);
            }
        }
    }

    public Set<PartnersAgreementsAddresses> getAgreements() {
        return agreements;
    }

    public void setAgreements(PartnersAgreementsAddresses agreement) {
        this.agreements.add(agreement);
        agreement.setAddress(this);
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

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getPrimary_address() {
        return primary_address;
    }

    public void setPrimary_address(String primary_address) {
        this.primary_address = primary_address;
    }

}
