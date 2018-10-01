package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="external_contact")
public class ExternalContact extends BaseEntity {


    private long account_id;

    private long created_by_user_id;

    @Temporal(TemporalType.DATE)
    private Date date_created;

    @Temporal(TemporalType.DATE)
    private Date last_updated_by_user_id;

    @Temporal(TemporalType.DATE)
    private Date date_last_updated;

    @NotNull
    @Size(min = 1,max = 150)
    private String first_name;

    @NotNull
    @Size(min = 1,max = 150)
    private String last_name;

    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Must be a valid email")
    private String email;

    @Size(min = 9,max = 13)
    private String phone;

    private long role_id;

    private boolean archived;


    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "externalContact")
    private Set<AddresesExternalContacts> addreses = new HashSet<>();


    public ExternalContact() {
    }

    public ExternalContact(long account_id, String first_name, String last_name) {
        this.account_id = account_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }


    public void addAddresesPartners(Partner partner, Address address) {
        AddresesExternalContacts addresesExternalContacts = new AddresesExternalContacts(partner,this, address, this.account_id);
        addreses.add(addresesExternalContacts);
        partner.getContacts().add(addresesExternalContacts);
        address.getContacts().add(addresesExternalContacts);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Set<AddresesExternalContacts> getAddreses() {
        return addreses;
    }

    public void setAddreses(Set<AddresesExternalContacts> addreses) {
        this.addreses = addreses;
    }
}
