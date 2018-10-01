package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="change_logs")
public class ChangeLog extends BaseEntity {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "current_user_id")
    private User current_user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by_id")
    private User created_by;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "last_updated_by_id")
    private User last_updated_by;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner_id")
    private Partner partner;

    private String log_details;
    private String log_summary;
    private Date date_created;

    private long account_id;

    public ChangeLog() {
    }

    public ChangeLog(String log_details, String log_summary, Date date_created, long account_id, User created_by) {
        this.log_details = log_details;
        this.log_summary = log_summary;
        this.date_created = date_created;
        this.account_id = account_id;
        this.created_by = created_by;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCurrent_user() {
        return current_user;
    }

    public void setCurrent_user(User current_user) {
        this.current_user = current_user;
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

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public String getLog_details() {
        return log_details;
    }

    public void setLog_details(String log_details) {
        this.log_details = log_details;
    }

    public String getLog_summary() {
        return log_summary;
    }

    public void setLog_summary(String log_summary) {
        this.log_summary = log_summary;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }
}
