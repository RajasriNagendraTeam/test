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
}
