package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "partners_agreements_addresses")
@IdClass(PartnersAgreementsAddressesId.class)
public class PartnersAgreementsAddresses {

    @Id
    @ManyToOne
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    private Partner partner;

    @Id
    @ManyToOne
    @JoinColumn(name = "agreement_id", referencedColumnName = "id")
    private Agreement agreement;

    @Id
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private long account_id;


    public PartnersAgreementsAddresses() {
    }

    public PartnersAgreementsAddresses(Partner partner, Agreement agreement, Address address, long account_id) {
        this.partner = partner;
        this.agreement = agreement;
        this.address = address;
        this.account_id = account_id;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PartnersAgreementsAddresses that = (PartnersAgreementsAddresses) o;
        return Objects.equals(partner, that.partner) &&
                Objects.equals(address, that.address) &&
                Objects.equals(agreement, that.agreement)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partner, address, agreement);
    }
}
