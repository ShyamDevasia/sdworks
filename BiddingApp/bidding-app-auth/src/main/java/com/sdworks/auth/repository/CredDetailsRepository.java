package com.sdworks.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdworks.auth.domain.CredDetails;
import com.sdworks.auth.domain.UserDetails;

@Repository
public interface CredDetailsRepository extends CrudRepository<CredDetails, Integer>{
	CredDetails findByUserDetails(UserDetails user);
}
