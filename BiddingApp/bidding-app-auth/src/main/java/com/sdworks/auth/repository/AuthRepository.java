package com.sdworks.auth.repository;

import org.springframework.data.repository.CrudRepository;

import com.sdworks.auth.domain.UserDetails;

public interface AuthRepository extends CrudRepository<UserDetails, Long>{

	UserDetails findByUsername(String uname);
}
