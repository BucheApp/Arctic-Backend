package com.bucheapp.arctic_api.controller;

import static com.bucheapp.arctic_api.userdata.ValidationInfo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bucheapp.arctic_api.object.RegisterAllObject;
import com.bucheapp.arctic_api.service.MatchService;

import reactor.core.publisher.Mono;

@RestController
public class RegisterRestController {
	@Autowired
	MatchService matchService;
	
	@PostMapping("/register/all")
	@CrossOrigin(value="http://localhost:5173")
	public Mono<String> all(
			@RequestBody Mono<RegisterAllObject> data
			) {
		return data.flatMap(d -> {
			String username = d.getUsername();
			String email = d.getEmail();
			String password = d.getPassword();
			
			String usernameMessage = matchService.match(username, USERNAME_MIN, USERNAME_MAX, USERNAME_REGEX);
			String emailMessage = matchService.match(email, EMAIL_MIN, EMAIL_MAX, EMAIL_REGEX);
			String passwordMessage = matchService.match(password, PASSWORD_MIN, PASSWORD_MAX, PASSWORD_REGEX);
			
			
			return Mono.just("Test!");
		});
	}
	
}
