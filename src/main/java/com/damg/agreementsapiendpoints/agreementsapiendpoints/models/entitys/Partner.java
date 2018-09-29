package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="partners_tbl")
public class Partner extends BaseEntity {

    //<editor-fold desc="Propertys">
    private String institution_name;
    private String partner_description;
    private String partner_website_url;
    private int total_partners_count;
    private boolean archived;
    private boolean is_dirty;
    private int replace_with;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="USER_ID", unique= true)
    private User user;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="CREATEDBY_ID", unique= true)
    private User created_by;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="LASTUPDATEDBY_ID", unique= true)
    private User last_updated_by;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "partner_addresses", joinColumns = { @JoinColumn(name = "parter_id") }, inverseJoinColumns = { @JoinColumn(name = "address_id") })
    private Set<Address> addresses = new HashSet<>();

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="PRIMARYADDRESS_ID", unique= true)
    private Address  primary_address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,  mappedBy = "partner")
    private Set<Agreement> agreements = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,  mappedBy = "partner")
    private Set<Error> errors;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date_created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date_last_updated;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Partner() {
    }
    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getPartner_description() {
        return partner_description;
    }

    public void setPartner_description(String partner_description) {
        this.partner_description = partner_description;
    }

    public String getPartner_website_url() {
        return partner_website_url;
    }

    public void setPartner_website_url(String partner_website_url) {
        this.partner_website_url = partner_website_url;
    }

    public int getTotal_partners_count() {
        return total_partners_count;
    }

    public void setTotal_partners_count(int total_partners_count) {
        this.total_partners_count = total_partners_count;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isIs_dirty() {
        return is_dirty;
    }

    public void setIs_dirty(boolean is_dirty) {
        this.is_dirty = is_dirty;
    }

    public int getReplace_with() {
        return replace_with;
    }

    public void setReplace_with(int replace_with) {
        this.replace_with = replace_with;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCreated_by() {
        return created_by;
    }

    public void setCreated_by(User created_by) {
        this.created_by = created_by;
    }

    public User getLast_updated_by() {
        return last_updated_by;
    }

    public void setLast_updated_by(User last_updated_by) {
        this.last_updated_by = last_updated_by;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Address getPrimary_address() {
        return primary_address;
    }

    public void setPrimary_address(Address primary_address) {
        this.primary_address = primary_address;
    }

    public Set<Agreement> getAgreements() {
        return agreements;
    }

    public void setAgreements(Set<Agreement> agreements) {
        this.agreements = agreements;
    }

    public Set<Error> getErrors() {
        return errors;
    }

    public void setErrors(Set<Error> errors) {
        this.errors = errors;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_last_updated() {
        return date_last_updated;
    }

    public void setDate_last_updated(Date date_last_updated) {
        this.date_last_updated = date_last_updated;
    }
    //</editor-fold>
}
