package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Agreement extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id", nullable = false)
    private Partner partner;
}
