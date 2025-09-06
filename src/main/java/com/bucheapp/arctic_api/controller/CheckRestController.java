package com.bucheapp.arctic_api.controller;

import static com.bucheapp.arctic_api.userdata.ValidationInfo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bucheapp.arctic_api.service.MatchService;

import reactor.core.publisher.Mono;

@RestController
public class CheckRestController {
	@Autowired
	MatchService matchService;
	
	@PostMapping("/check/username")
	@CrossOrigin(value="http://localhost:5173")
	public Mono<String> username(
			@RequestBody Mono<String> text
			) {
		return text.flatMap(s -> {
			return Mono.just(matchService.match(s,USERNAME_MIN,USERNAME_MAX,USERNAME_REGEX));
		});
	}
	
	@PostMapping("/check/email")
	@CrossOrigin(value="http://localhost:5173")
	public Mono<String> email(
			@RequestBody Mono<String> text
			) {
		return text.flatMap(s -> {
			return Mono.just(matchService.match(s,EMAIL_MIN,EMAIL_MAX,EMAIL_REGEX));
		});
	}
	
	@PostMapping("/check/password")
	@CrossOrigin(value="http://localhost:5173")
	public Mono<String> password(
			@RequestBody Mono<String> text
			) {
		return text.flatMap(s -> {
			return Mono.just(matchService.match(s,PASSWORD_MIN,PASSWORD_MAX,PASSWORD_REGEX));
		});
	}
}
