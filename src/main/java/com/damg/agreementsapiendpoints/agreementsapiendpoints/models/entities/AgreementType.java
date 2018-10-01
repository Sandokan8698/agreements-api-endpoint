package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="agreemntes_types")
public class AgreementType extends BaseEntity {


    @NotNull
    @Size(max = 250)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "agreementsTypes")
    private Set<Agreement> agreements = new HashSet<>();


}
