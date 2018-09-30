package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;


import javax.persistence.*;

@Entity
@Table(name = "partners_addresses")
@IdClass(PartnerAddressesId.class)
public class PartnerAddresses {

    @Id
    @ManyToOne
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    private Partner partner;

    @Id
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    private long account_id;

    public PartnerAddresses() {
    }

    public PartnerAddresses(Partner partner, Address address, long account_id) {
        this.partner = partner;
        this.address = address;
        this.account_id = account_id;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
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
}
