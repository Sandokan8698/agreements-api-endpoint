package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.services;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.AddressDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entities.Address;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entities.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AddressService {

    @Autowired
    AddressDAO addressDAO;


    @Transactional
    public void CopyAddress(long addressId, long accountId, Partner partner) {

        Set<Address> address = addressDAO.getAddressByAccountAndId(addressId, accountId);
        List<Address> newAddreses = new ArrayList<>();

        address.forEach(a -> {
            Address newAddress = new Address(a.getAccount_id(), a.getCity(), a.getState(), a.getCountry());
            newAddreses.add(newAddress);

        });

        addressDAO.saveAll(newAddreses);

        newAddreses.forEach(na -> {
            na.addPartner(partner);
        } );

        addressDAO.saveAll(newAddreses);
    }
}
