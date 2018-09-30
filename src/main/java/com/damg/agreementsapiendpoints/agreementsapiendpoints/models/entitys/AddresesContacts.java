package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "partners_addresses")
@IdClass(AddresesContacts.class)
public class AddresesContacts {

}
