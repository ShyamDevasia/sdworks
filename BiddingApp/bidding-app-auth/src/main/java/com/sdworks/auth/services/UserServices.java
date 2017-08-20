package com.sdworks.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdworks.auth.domain.CredDetails;
import com.sdworks.auth.domain.UserDetails;
import com.sdworks.auth.repository.CredDetailsRepository;
import com.sdworks.auth.repository.UserDetailsRepository;
import com.sdworks.auth.vo.UserVO;

@Service
public class UserServices {
	
	@Autowired
	CredDetailsRepository credDetailsRepository;
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	public boolean saveUser(UserVO user){
		UserDetails userDet = new UserDetails();
		userDet.setEmail(user.getEmail());
		userDet.setUsername(user.getUsername());
		userDetailsRepository.save(userDet);
		
		CredDetails creds = new CredDetails();
		creds.setUserDetails(userDet);
		creds.setPassword(user.getPassword());
		saveCreds(creds);
		
		return true;
	}
	
	public boolean saveCreds(CredDetails creds){
		credDetailsRepository.save(creds);
		return true;
	}
	
	public boolean isUserValid(String username, String password){
		try{
			UserDetails user = userDetailsRepository.findByUsername(username);
			CredDetails cred = credDetailsRepository.findByUserDetails(user);
			if(!password.equals(cred.getPassword())){
				return false;
			}
		} catch(Exception e){
			return false;
		}
		return true;
	}

}
