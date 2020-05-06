package com.rs.fer.util;

import com.rs.fer.model.User;
import com.rs.fer.request.RegistrationVO;

public class FERUtil {

	public static User loadRegistrationVOToUser(RegistrationVO registrationVO) {
		User user = new User();

		user.setFirstName(registrationVO.getFirstName());
		user.setMiddleName(registrationVO.getMiddleName());
		user.setLastName(registrationVO.getLastName());

		user.setEmail(registrationVO.getEmail());
		user.setMobile(registrationVO.getMobile());

		user.setUserName(registrationVO.getUserName());
		user.setPassword(registrationVO.getPassword());

		user.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));

		return user;

	}
	
	public static User loadUpdateUserVOToUser(User user, User userdb) {
		userdb.setFirstName(user.getFirstName());
		userdb.setMiddleName(user.getMiddleName());
		userdb.setLastName(user.getLastName());
		userdb.setEmail(user.getEmail());
		userdb.setMobile(user.getMobile());
		
		if(!user.getAddress().getLineOne().isEmpty())
		{
			userdb.getAddress().setLineOne(user.getAddress().getLineOne());
			userdb.getAddress().setLineTwo(user.getAddress().getLineTwo());
			userdb.getAddress().setCity(user.getAddress().getCity());
			userdb.getAddress().setState(user.getAddress().getState());
			userdb.getAddress().setPostal(user.getAddress().getPostal());
			userdb.getAddress().setCountry(user.getAddress().getCountry());
			
		}
		user.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		return userdb;

	}
	
}
