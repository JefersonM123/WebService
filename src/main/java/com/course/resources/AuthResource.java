package com.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.dto.CredentialsDTO;
import com.course.dto.TokenDTO;
import com.course.entities.User;
import com.course.repositories.UserRepository;
import com.course.services.AuthService;
import com.course.services.exceptions.JWTAuthorizationException;

@RestController
@RequestMapping(value= "/auth")
public class AuthResource {
	
	@Autowired
	private AuthService service;
	
	@PostMapping("/login")
	public ResponseEntity<TokenDTO> login(@RequestBody CredentialsDTO dto){
		TokenDTO tokenDTO = service.authenticate(dto);
		return ResponseEntity.ok().body(tokenDTO);
	}
}