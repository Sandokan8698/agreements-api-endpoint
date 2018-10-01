package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.services;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.ExternalConctactDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ExternalContactService {

    @Autowired
    ExternalConctactDAO externalConctactDAO;

    @Transactional
    public void CopyExternalContact(long externalConctactId, long accountId, Partner partner, Address address) {

        Set<ExternalContact> externalContacts = externalConctactDAO.getExternalContactByAccountAndId(externalConctactId, accountId);
        List<ExternalContact>  newExternalConctacts = new ArrayList<>();

        externalContacts.forEach(e -> {

            ExternalContact newExternalContact = new ExternalContact(e.getAccount_id(),e.getFirst_name(),e.getLast_name());
            newExternalConctacts.add(newExternalContact);

        });

        externalConctactDAO.saveAll(newExternalConctacts);

        newExternalConctacts.forEach(ec -> {
            ec.addAddresesPartners(partner,address);
        });

        externalConctactDAO.saveAll(newExternalConctacts);


    }
}
