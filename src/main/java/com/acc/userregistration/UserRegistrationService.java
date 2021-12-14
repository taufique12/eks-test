package com.acc.userregistration;

public interface UserRegistrationService {

	UserModel save(UserModel userRegistrationModel) throws Exception;

	UserModel updateUser(UserModel userRegistrationModel);
}
