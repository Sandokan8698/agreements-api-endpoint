package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class ExternalContact implements BaseEntity {

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



    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "externalContact")
    private Set<AddresesExternalContacts> contacts;

    @Override
    public Long getId() {
        return id;
    }
}
