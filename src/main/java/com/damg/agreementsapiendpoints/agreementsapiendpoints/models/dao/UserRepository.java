package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

