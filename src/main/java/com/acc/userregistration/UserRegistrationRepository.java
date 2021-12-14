package com.acc.userregistration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@XRayEnabled
@Repository
public interface UserRegistrationRepository extends JpaRepository<UserModel, Integer> {

	@SuppressWarnings("unchecked")
	UserModel save(UserModel userRegistrationModel);
	
	UserModel findByUserId(Integer userId);
}
