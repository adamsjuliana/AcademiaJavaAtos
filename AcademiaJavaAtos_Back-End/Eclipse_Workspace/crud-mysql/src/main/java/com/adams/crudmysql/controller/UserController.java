package com.adams.crudmysql.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.adams.crudmysql.model.User;
import com.adams.crudmysql.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;


@Controller //Informa que classe UserController é o nosso controller
@RequestMapping(path="/crud")
public class UserController {
	
	@Autowired //Comunica com o UserRepository
	private UserRepository userRepository;
	
    @GetMapping(path="/home")
    public String home() {
        return "home";
    }
    @GetMapping(path="/add")
    public String add(Model model) {
    	model.addAttribute("user", new User());
        return "cadastrar";
    }
	//Create
	@PostMapping(path="/add") //add?name=Juliana&email=juliana@gmail
	public String addUser(@RequestParam String name, @RequestParam String email, Model model) {
	//Realiza o incapsulamento dos dados;
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		userRepository.save(u);
        Iterable<User> listaUser = userRepository.findAll();
        model.addAttribute("user", listaUser);
		return "listar";
	}
	//Read - select * from user
	@GetMapping(path="/all")
    public String setUser(@ModelAttribute User user, Model model) {
        Iterable<User> listaUser = userRepository.findAll();
        model.addAttribute("user", listaUser);
        return "listar";
    }
    @GetMapping(path="/delete/{id}")
    public String excluir(@PathVariable Integer id, Model model) {
    	userRepository.deleteById(id);
        Iterable<User> listaUser = userRepository.findAll();
        model.addAttribute("user", listaUser);
    	return "listar";
    }
    @GetMapping(path="/{id}")
    User getUser(@PathVariable Integer id) {
    	return userRepository.findById(id).get();
    }
    
    @GetMapping(path="/update/{id}")
    public String altUser(@PathVariable Integer id, Model model) {
    	User u = userRepository.findById(id).get();
    	model.addAttribute("user",u);
    	return "editar";
    }
    @PostMapping(path="/update")
    public String updateUser(@ModelAttribute User novoUser, Model model) {
    	User u = userRepository.findById(novoUser.getId()).get();
    	u.setName(novoUser.getName());
    	u.setEmail(novoUser.getEmail());
    	userRepository.save(u);
    	Iterable<User> listaUser = userRepository.findAll();
    	model.addAttribute("user", listaUser);
    	return "listar";
    }
}
