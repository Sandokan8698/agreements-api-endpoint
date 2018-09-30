package com.damg.agreementsapiendpoints.agreementsapiendpoints;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.Services.AddressService;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.Services.PartnerService;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.AddressDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.PartnerDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.PartnerAddressDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.UserDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Address;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.PartnerAddresses;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.User;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryBuilder;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.util.*;
import java.util.logging.Logger;

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

    @Autowired
    private PartnerAddressDAO partnerAddressDAO;

    @Autowired
    private UserDAO userDAO;


    private User user1;
    private User user2;
    private Partner partner1;
    private Partner partner2;
    private Address oldAddress;


    @Before
    public void setUp() throws Exception {

        user1 = new User("abdel","mendez");
        user2 = new User("benedicto","mendez");

         partner1 = new Partner(user1,"software engineer");
         partner2 = new Partner(user2,"medic");

        oldAddress = new Address(1,"Guayas","Guayaquil","Ecuador");
        oldAddress = addressDAO.save(oldAddress);

        partnerDAO.save(partner1);
        partnerDAO.save(partner2);

        PartnerAddresses partnerAddresses = new PartnerAddresses();
        partnerAddresses.setAccount_id(1);
        partnerAddresses.setPartner(partner1);
        partnerAddresses.setAddress(oldAddress);

        partnerAddressDAO.save(partnerAddresses);


    }

    @Test
    public void assertCopyAddressIsWorking()
    {
        addressService.CopyAddress(oldAddress.getId(),oldAddress.getAccount_id(),partner2);

        Optional<Partner> test = partnerDAO.findById(partner2.getId());

        assertTrue(!test.get().getAddresses().isEmpty());
    }

    @After
    public  void After()
    {

    }
}
