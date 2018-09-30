package com.damg.agreementsapiendpoints.agreementsapiendpoints;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.Services.AddressService;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.Services.PartnerService;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.AddressDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.PartnerDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Address;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private PartnerDAO partnerDAO;

    private Partner partner1;
    private Partner partner2;
    private Address oldAddress;


    @Before
    public void setUp() throws Exception {


        partner1 = new Partner(null,"software engineer");
        partner2 = new Partner(null,"medic");

        partnerDAO.save(partner1);
        partnerDAO.save(partner2);

        oldAddress = new Address(1,"Guayas","Guayaquil","Ecuador");
        oldAddress = addressDAO.save(oldAddress);

        oldAddress.addPartner(partner1);
        addressDAO.save(oldAddress);


    }

    @Test
    public void assertCopyAddressIsWorking()
    {
        assertTrue(partnerDAO.findById(partner2.getId()).get().getAddresses().isEmpty());

        addressService.CopyAddress(oldAddress.getId(),oldAddress.getAccount_id(),partner2);

        assertTrue(!partnerDAO.findById(partner2.getId()).get().getAddresses().isEmpty());

    }

    @After
    public  void After()
    {
        addressDAO.deleteAll();
        partnerDAO.deleteAll();
    }
}
