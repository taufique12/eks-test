package com.acc.userregistration;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.acc.userregistration.exception.UserNotFoundException;

@CrossOrigin(origins = "*")
@Transactional
@RestController
@RequestMapping(path = "/v1")
public class UserRegistrationController {

	private UserRegistrationService userRegistrationService;

	@Autowired
	public UserRegistrationController(UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}

	@PostMapping("/user")
	public ResponseEntity<Object> saveUser(@RequestBody UserModel userRegistrationModel) throws Exception {

		UserModel user = userRegistrationService.save(userRegistrationModel);

		URI dataLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getUserId()).toUri();

		return ResponseEntity.created(dataLocation).build();
	}

	@PutMapping("/user")
	public UserModel updateUser(@RequestBody UserModel userRegistrationModel) throws Exception {

		UserModel user = userRegistrationService.updateUser(userRegistrationModel);

		if (user != null) {
			return user;
		} else {
			throw new UserNotFoundException("id-" + userRegistrationModel.getUserId() + " not found");
		}

	}

}
