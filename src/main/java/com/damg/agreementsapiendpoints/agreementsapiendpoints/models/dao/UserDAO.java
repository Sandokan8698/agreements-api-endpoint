package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
}
