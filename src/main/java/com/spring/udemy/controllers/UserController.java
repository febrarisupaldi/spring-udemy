package com.spring.udemy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.udemy.models.responses.UserResponse;

@RestController
@RequestMapping("/users")
public class UserController {
	
//	@GetMapping
//	public String getUser() {
//		return "Get User";
//	}
//	
	@GetMapping()
	public String getUsers(@RequestParam(value="page", defaultValue = "1") int page, 
			@RequestParam(value="limit", defaultValue = "10") int limit,
			@RequestParam(value="sort", required = false) String sort) {
		return "Get Method for query string for page " + page + " and limit " + limit + " and sort " + sort;
	}
	
	@GetMapping(path="/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponse> getUserDetail(@PathVariable Long id) {
		UserResponse resp = new UserResponse();
		resp.setFirstName("Febrari");
		resp.setLastName("Supaldi");
		resp.setEmail("paldi@gmail.com");
		resp.setUserId((String) id.toString());
		
		return new ResponseEntity<UserResponse>(resp, HttpStatus.OK);
		//return new ResponseEntity<UserResponse>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping
	public String postUser() {
		return "Post Method";
	}
	
	@PutMapping
	public String putUser() {
		return "Put Method";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete Method";
	}
	
}
