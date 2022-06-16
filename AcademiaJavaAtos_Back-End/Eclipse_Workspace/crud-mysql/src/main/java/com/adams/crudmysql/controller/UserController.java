package com.adams.crudmysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.adams.crudmysql.model.User;
import com.adams.crudmysql.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Controller //Informa que classe UserController é o nosso controller
@RequestMapping(path="/crud")
public class UserController {
	
	@Autowired //Comunica com o UserRepository
	private UserRepository userRepository;
	
	//Create
	@PostMapping(path="/add") //add?name=Juliana&email=juliana@gmail
	public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email) {
	//Realiza o incapsulamento dos dados;
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		userRepository.save(u);
		return "Salvo";
	}
	
	//Read - select * from user
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> allUser(){
		return userRepository.findAll();
	}
	
	//Delete
	@DeleteMapping(path="/delete")
	public @ResponseBody String deleteUser(@RequestParam Integer id) {
		userRepository.deleteById(id);
		return "Apagado";
	}
	
	//Update
	@PutMapping(path="/update")
	public @ResponseBody String updateUser(@RequestParam Integer id, @RequestParam String name, @RequestParam String email){
		User u = userRepository.findById(id).get();
		if(!name.isEmpty()) {
		u.setName(name);		
		}
		if(!email.isEmpty()) {
	    u.setEmail(email);
		}
    	userRepository.save(u);
		return "Alterado";
	}
	
}
