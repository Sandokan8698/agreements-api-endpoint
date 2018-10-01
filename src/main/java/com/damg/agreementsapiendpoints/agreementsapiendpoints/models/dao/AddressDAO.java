package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Set;


public interface AddressDAO extends JpaRepository<Address, Long> {

    @Query("SELECT a FROM Address a where id = :id AND account_id =  :old_accountId")
    Set<Address> getAddressByAccountAndId(@Param("id") Long id, @Param("old_accountId") Long old_accountId);
}
