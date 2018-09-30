package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.*;

@Entity
@Table(name = "addresses_external_contacts")
@IdClass(AddresesExternalContacstId.class)
public class AddresesExternalContacts {


    @Id
    @ManyToOne
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    private Partner partner;

    @Id
    @ManyToOne
    @JoinColumn(name = "external_contact_id", referencedColumnName = "id")
    private ExternalContact externalContact;

    @Id
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private long account_id;

    public AddresesExternalContacts() {
    }

    public AddresesExternalContacts(Partner partner, ExternalContact externalContact, Address address, long account_id) {
        this.partner = partner;
        this.externalContact = externalContact;
        this.address = address;
        this.account_id = account_id;
    }
}
