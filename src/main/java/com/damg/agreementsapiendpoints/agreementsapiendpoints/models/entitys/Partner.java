package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="partners")
public class Partner  implements IBaseEntity {

    //<editor-fold desc="Propertys">

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    public Long getId() {
        return id;
    }

    private String institution_name = "";
    private String partner_description = "";
    private String partner_website_url = "";
    private int total_partners_count = 0;
    private boolean archived = false;
    private boolean is_dirty = false;
    private int replace_with = 0;
    private int account_id = 0;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="CREATEDBY_ID")
    private User created_by;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="LASTUPDATEDBY_ID")
    private User last_updated_by;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "partner", orphanRemoval = true)
    private Set<PartnerAddresses> addresses = new HashSet<>();

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="PRIMARYADDRESS_ID")
    private Address  primary_address;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "partner")
    private Set<PartnersAgreementsAddresses> agreements;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "partner")
    private Set<Error> errors;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date_created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date_last_updated;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "partner")
    private Set<AddresesExternalContacts> contacts = new HashSet<>();
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Partner() {


    }

    public Partner(User user, String partner_description) {
        this.partner_description = partner_description;
        this.user = user;
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

    public Address getPrimary_address() {
        return primary_address;
    }

    public void setPrimary_address(Address primary_address) {
        this.primary_address = primary_address;
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

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public Set<PartnersAgreementsAddresses> getAgreements() {
        return agreements;
    }

    public Set<PartnerAddresses> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<PartnerAddresses> addresses) {
        this.addresses = addresses;
    }

    public void setAgreements(Set<PartnersAgreementsAddresses> agreements) {
        this.agreements = agreements;
    }

    public Set<AddresesExternalContacts> getContacts() {
        return contacts;
    }

    public void setContacts(Set<AddresesExternalContacts> contacts) {
        this.contacts = contacts;
    }
//</editor-fold>
}
