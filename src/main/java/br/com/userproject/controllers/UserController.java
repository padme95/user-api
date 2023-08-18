package br.com.userproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.userproject.entities.UserEntity;
import br.com.userproject.services.UserService;


@RestController
@RequestMapping(value = "usuarios")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserEntity> getUsers () {
		return userService.getAll();	
		}
	
	@GetMapping("{id}")
	public UserEntity getOne(@PathVariable Integer id) {
		return userService.getOne(id);
	}

	@PostMapping("")
	public UserEntity save(@RequestBody UserEntity user) {
		return userService.save(user);
	}
	
	@PatchMapping("{id}")
	public UserEntity update(@PathVariable Integer id, @RequestBody UserEntity user) {
		return userService.update(id, user);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
	  userService.delete(id);
	}
}
