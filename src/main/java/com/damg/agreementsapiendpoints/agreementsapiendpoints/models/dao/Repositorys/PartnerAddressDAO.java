package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.Repositorys;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.PartnerAddresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerAddressDAO extends JpaRepository<PartnerAddresses, Long> {
}
