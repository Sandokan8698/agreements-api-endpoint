package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="addreses")
public class Address extends BaseEntity {

    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "address")
    private Set<PartnerAddresses> partners;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "address")
    private Set<PartnersAgreementsAddresses> agreements;

    private long account_id;
    private String city;
    private String state;
    private String country;
    private float latitude;
    private float longitude;
    private String primary_address;

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

    public void setPartners(Set<PartnerAddresses> partners) {
        this.partners = partners;
    }

    public Set<PartnersAgreementsAddresses> getAgreements() {
        return agreements;
    }

    public void setAgreements(Set<PartnersAgreementsAddresses> agreements) {
        this.agreements = agreements;
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
