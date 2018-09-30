package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class ExternalContact extends BaseEntity {

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


    private long partner_id;
    private long address_id;
    private long external_contact_id;
}
