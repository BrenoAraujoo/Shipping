package com.shipping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipping.entities.User;
import com.shipping.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> list() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = userService.findByid(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user){
		user = userService.save(user);
		return ResponseEntity.ok().body(user);
		
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		userService.delete(id);
		return new ResponseEntity<>("sucessfull deleted: " + id,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody User user){
		userService.update(user);
		return new ResponseEntity<>("Sucessfully updated: " + user.getName(),
				HttpStatus.OK);
	}

}
