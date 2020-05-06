package com.rs.fer.validation.impl;

import java.util.Set;

import com.rs.fer.request.RegistrationVO;

public interface ValidationUtil {
	Set<String> validateRegistrationRequest(RegistrationVO registrationVO);

}
