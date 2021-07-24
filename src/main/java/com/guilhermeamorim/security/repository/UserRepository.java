package com.guilhermeamorim.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.guilhermeamorim.security.model.User;

public interface UserRepository extends CrudRepository <User, Long> {
    User findByUsername(String username);
}