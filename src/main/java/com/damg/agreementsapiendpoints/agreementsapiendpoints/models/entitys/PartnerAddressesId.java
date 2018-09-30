package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import java.io.Serializable;
import java.util.Objects;

public class PartnerAddressesId implements Serializable {

    private long partner;
    private long address;

    public PartnerAddressesId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PartnerAddressesId that = (PartnerAddressesId) o;
        return Objects.equals(partner, that.partner) &&  Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partner, address);
    }
}
