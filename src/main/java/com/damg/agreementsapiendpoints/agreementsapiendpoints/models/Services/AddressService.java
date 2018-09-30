package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.Services;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.AddressDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.PartnerAddressDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Address;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.PartnerAddresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class AddressService {

    @Autowired
    AddressDAO addressDAO;

    @Autowired
    PartnerAddressDAO partnerAddressDAO;

    @Transactional
    public void CopyAddress(long addressId, long accountId, Partner partner) {

        Set<Address> address = addressDAO.getAddressByAccountAndId(addressId, accountId);

        address.forEach(a -> {

            Address newAddress = new Address(a.getAccount_id(), a.getCity(), a.getState(), a.getCountry());
            PartnerAddresses partnerAddresses = new PartnerAddresses(partner, newAddress, newAddress.getAccount_id());

            addressDAO.save(newAddress);
            partnerAddressDAO.save(partnerAddresses);

        });


    }
}
