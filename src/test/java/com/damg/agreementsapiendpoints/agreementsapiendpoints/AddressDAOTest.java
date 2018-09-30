package com.damg.agreementsapiendpoints.agreementsapiendpoints;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.AddressDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.PartnerDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Address;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryBuilder;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDAOTest {


    @Autowired
    private AddressDAO addressDAO;

    Address address;

    @Before
    public void setUp() throws Exception {

        address = new Address(1,"Guayaquil","Guayas","Ecuador");
        address =  addressDAO.save(address);
    }

    @Test
    public void assertNotResultInPartner()
    {

        Optional<Address> tetAddres = addressDAO.getAddressByAccountAndId( address.getId(),1l);

        assertTrue(tetAddres != null);
    }

    @After
    public void After()
    {
        addressDAO.deleteAll();
    }

}
