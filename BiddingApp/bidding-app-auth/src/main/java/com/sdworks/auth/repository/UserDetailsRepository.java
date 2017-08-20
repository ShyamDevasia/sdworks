package com.sdworks.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdworks.auth.domain.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Integer>{

	UserDetails findByUsername(String uname);
}
