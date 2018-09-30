package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class ExternalContact implements IBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    private long account_id;

    private long created_by_user_id;
    private Date date_created;
    private Date last_updated_by_user_id;
    private Date date_last_updated;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private long role_id;
    private boolean archived;



    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "externalContact")
    private Set<AddresesExternalContacts> contacts;

    @Override
    public Long getId() {
        return id;
    }


    public ExternalContact() {
    }

    public ExternalContact(long account_id, String first_name, String last_name) {
        this.account_id = account_id;
        this.first_name = first_name;
        this.last_name = last_name;
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

    public long getCreated_by_user_id() {
        return created_by_user_id;
    }

    public void setCreated_by_user_id(long created_by_user_id) {
        this.created_by_user_id = created_by_user_id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getLast_updated_by_user_id() {
        return last_updated_by_user_id;
    }

    public void setLast_updated_by_user_id(Date last_updated_by_user_id) {
        this.last_updated_by_user_id = last_updated_by_user_id;
    }

    public Date getDate_last_updated() {
        return date_last_updated;
    }

    public void setDate_last_updated(Date date_last_updated) {
        this.date_last_updated = date_last_updated;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Set<AddresesExternalContacts> getContacts() {
        return contacts;
    }

    public void setContacts(Set<AddresesExternalContacts> contacts) {
        this.contacts = contacts;
    }
}
