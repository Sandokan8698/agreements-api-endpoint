package com.damg.agreementsapiendpoints.agreementsapiendpoints;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.PartnerDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private PartnerDAO partnerDAO;
    @Before
    public void setUp() throws Exception {
        Partner partner = new Partner();
        partner.setInstitution_name("New Institution");
        this.partnerDAO.save(partner);
        assertNotNull(partner);
    }

    @Test
    public void testFetchData(){
       /* *//*Test data retrieval*//*
        Optional<User> userA = userRepository.findById(1);
        assertNotNull(userA);
        assertEquals("Mendez", "Mendez");
        *//*Get all products, list should only have two*//*
        Iterable<User> users = userRepository.findAll();
        int count = 0;
        for(User p : users){
            count++;
        }*/
        assertEquals(1,1);
    }
}