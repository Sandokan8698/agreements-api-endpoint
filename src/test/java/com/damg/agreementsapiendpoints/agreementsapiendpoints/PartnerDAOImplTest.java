package com.damg.agreementsapiendpoints.agreementsapiendpoints;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.PartnerDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.Implementation.PartnerDAOImpl;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryBuilder;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PartnerDAOImplTest {

    @Autowired
    private PartnerDAO partnerDAO;

    @Autowired
    private PartnerQueryBuilder partnerQueryBuilder;
    PartnerQueryFilter filter;


    @Before
    public void setUp() throws Exception {

        filter = new PartnerQueryFilter();
        filter.setAccount_id(1);
        filter.setAgreement_type_id(1);
    }

    @Test
    public void assertNotResultInPartner()
    {
        assertTrue(partnerDAO.getPartnersList(filter).isEmpty());
    }

    @Test
    public void assertgetTotalPartnersIsCero()
    {
        assertEquals(0,partnerDAO.getTotalPartners(filter));
    }

    @Test
    public void assertNotResultInDebugList()
    {
        assertTrue(partnerDAO.getDebugPartnerList(filter).isEmpty());
    }
}
