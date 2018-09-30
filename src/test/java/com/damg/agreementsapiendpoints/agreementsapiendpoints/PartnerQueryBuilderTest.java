package com.damg.agreementsapiendpoints.agreementsapiendpoints;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.PartnerQueryBuilder;
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
public class PartnerQueryBuilderTest {


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
    public void assertAccountIdIsSet(){
       assertTrue(partnerQueryBuilder.buildSqlCommand(filter).contains("ptr.account_id = 1"));
    }

    @Test
    public void assertAgreementTypeIdIsSet(){
        assertTrue(partnerQueryBuilder.buildSqlCommand(filter).contains("AND agr_xref.agreement_type_id IN(:agreement_type_id)"));
    }
}
