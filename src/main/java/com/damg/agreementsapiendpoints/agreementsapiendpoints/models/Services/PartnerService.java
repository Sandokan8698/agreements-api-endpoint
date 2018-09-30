package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.Services;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.AddressDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.PartnerDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Address;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.PartnerAddresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PartnerService {

    @Autowired
    PartnerDAO partnerDAO;

    @Autowired
    AddressDAO addressDAO;


}
