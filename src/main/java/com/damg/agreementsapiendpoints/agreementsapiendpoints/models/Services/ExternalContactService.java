package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.Services;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.AddressDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.ExternalConctactDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.AddresesExternalContactDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys.PartnerAddressDAO;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ExternalContactService {

    @Autowired
    ExternalConctactDAO externalConctactDAO;

    @Autowired
    AddresesExternalContactDAO addresesExternalContactDAO;

    @Transactional
    public void CopyExternalContact(long externalConctactId, long accountId, Partner partner, Address address) {

        Set<ExternalContact> externalContacts = externalConctactDAO.getExternalContactByAccountAndId(externalConctactId, accountId);


        externalContacts.forEach(e -> {

            ExternalContact newExternalContact = new ExternalContact(e.getAccount_id(),e.getFirst_name(),e.getLast_name());
            AddresesExternalContacts addresesExternalContact = new AddresesExternalContacts(partner,newExternalContact,address,accountId);

            externalConctactDAO.save(newExternalContact);
            addresesExternalContactDAO.save(addresesExternalContact);

        });

    }
}
