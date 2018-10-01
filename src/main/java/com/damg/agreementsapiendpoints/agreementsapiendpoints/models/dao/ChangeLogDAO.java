package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entities.ChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeLogDAO extends JpaRepository<ChangeLog, Long> {
}
