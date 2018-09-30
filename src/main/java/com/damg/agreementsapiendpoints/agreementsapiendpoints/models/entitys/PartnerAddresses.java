package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;


import javax.persistence.*;

@Entity
@Table(name = "partners_addresses")
@IdClass(PartnerAddressesId.class)
public class PartnerAddresses {

    @Id
    @ManyToOne
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    private Partner partner;

    @Id
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private long account_id;
}
