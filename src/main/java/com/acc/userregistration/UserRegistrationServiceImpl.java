package com.acc.userregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@XRayEnabled
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	private UserRegistrationRepository userRegistrationRepository;

	@Override
	public UserModel save(UserModel userRegistrationModel) throws Exception {
		return userRegistrationRepository.save(userRegistrationModel);
	}

	@Override
	public UserModel updateUser(UserModel userRegistrationModel) {
		UserModel user = userRegistrationRepository.findByUserId(userRegistrationModel.getUserId());
		if (user != null) {
			return userRegistrationRepository.save(userRegistrationModel);
		} else {
			return null;
		}
	}

}
