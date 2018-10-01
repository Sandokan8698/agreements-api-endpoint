package com.damg.agreementsapiendpoints.agreementsapiendpoints;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.PartnerDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PartnerDAOTest {

    @Autowired
    private PartnerDAO partnerDAO;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void assertCanExecutePartnerList()
    {

        PartnerQueryFilter  filter = new PartnerQueryFilter();
        filter.setAccount_id(1);
        filter.setAgreement_type_id(1);
        filter.setKeyword_search("hola abdel");
        filter.setSearch_fields(new String[] {"institution_name","partner_website_url"});

        assertEquals(0, partnerDAO.getTotalPartners(filter));
        assertTrue(partnerDAO.getPartnersList(filter).isEmpty());
        assertTrue(partnerDAO.getDebugPartnerList(filter).isEmpty());
    }

}
