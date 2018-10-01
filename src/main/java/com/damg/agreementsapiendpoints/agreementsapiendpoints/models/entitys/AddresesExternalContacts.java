package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses_external_contacts")
@IdClass(AddresesExternalContactsId.class)
public class AddresesExternalContacts {


    @Id
    @ManyToOne
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Partner partner;

    @Id
    @ManyToOne
    @JoinColumn(name = "external_contact_id", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private ExternalContact externalContact;

    @Id
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
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

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public ExternalContact getExternalContact() {
        return externalContact;
    }

    public void setExternalContact(ExternalContact externalContact) {
        this.externalContact = externalContact;
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

        AddresesExternalContacts that = (AddresesExternalContacts) o;
        return Objects.equals(partner, that.partner) &&
                Objects.equals(address, that.address) &&
                Objects.equals(address, that.externalContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partner, address,externalContact);
    }
}
