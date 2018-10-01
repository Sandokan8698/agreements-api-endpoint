package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import java.io.Serializable;
import java.util.Objects;

public class AddresesExternalContactsId implements Serializable {

   private long account_id;
   private long externalContact;
   private long address;
   private long partner;

   public AddresesExternalContactsId() {}

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;

      if (o == null || getClass() != o.getClass())
         return false;

      AddresesExternalContactsId that = (AddresesExternalContactsId) o;
      return Objects.equals(externalContact, that.externalContact)
              &&  Objects.equals(address, that.address)
              &&  Objects.equals(partner, that.partner);
   }

   @Override
   public int hashCode() {
      return Objects.hash(externalContact, address, partner);
   }
}
