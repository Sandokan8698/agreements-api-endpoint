package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.Services;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.PartnerDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.Partner;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Service
public class PartnerService {

    @Autowired
    PartnerDAO partnerDAO;


    @Transactional
    public void CopyPartner(long partnerId, long accountId, User user) {

        Set<Partner> partners = partnerDAO.getParnerByAccountAndId(partnerId,accountId);

        partners.forEach(a -> {
            Partner newPartner = new Partner( a.getInstitution_name(),a.getPartner_description(),a.getPartner_website_url(),a.getAccount_id());
            partnerDAO.save(newPartner);
        });

    }

}
