package com.damg.agreementsapiendpoints.agreementsapiendpoints;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.Services.AddressService;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.Services.ExternalContactService;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.AddressDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.ExternalConctactDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.PartnerDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Address;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.ExternalContact;
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
public class ExternalContactTest {

    @Autowired
    private ExternalContactService externalContactService;

    @Autowired
    private ExternalConctactDAO externalConctactDAO;

    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private PartnerDAO partnerDAO;

    private Partner partner1;
    private Partner partner2;
    private Address address;
    private ExternalContact oldExternalContact;


    @Before
    public void setUp() throws Exception {

        partner1 = new Partner("some institution","some description","some url",1);
        partnerDAO.save(partner1);

        partner2 = new Partner("some institution2","some description2","some url2",2);
        partnerDAO.save(partner2);

        address = new Address(1,"Guayas","Guayaquil","Ecuador");
        address = addressDAO.save(address);

        oldExternalContact = new ExternalContact(1,"some name","some lastname");
        oldExternalContact = externalConctactDAO.save(oldExternalContact);

        partner1.addExternalConctacts(oldExternalContact,address);


    }

    @Test
    public void assertCopyExternalContactIsWorking()
    {
        assertTrue(partnerDAO.findById(partner2.getId()).get().getContacts().isEmpty());

        externalContactService.CopyExternalContact(oldExternalContact.getId(),oldExternalContact.getAccount_id(),partner2,address);

        assertTrue(!partnerDAO.findById(partner2.getId()).get().getContacts().isEmpty());

    }

    @After
    public  void After()
    {
        addressDAO.deleteAll();
        partnerDAO.deleteAll();
    }

}
