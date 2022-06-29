package com.adams.JUsers.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adams.JUsers.Models.Usuario;
import com.adams.JUsers.Repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;


@Controller //Informa que classe UserController é o nosso controller
@RequestMapping("/")
public class ControllerUsuario {
	
	@Autowired //Comunica com o UserRepository
	private UsuarioRepository usuarioRepository;
	
    @GetMapping("/add")
    public String add(Model model) {
    	model.addAttribute("usuario", new Usuario());
        return "cadastrar";
    }
	@PostMapping("/add") //add?name=Juliana&email=juliana@gmail
	public String addUser(@RequestParam String email, @RequestParam String senha, @RequestParam String role, Model model) {
	//Realiza o incapsulamento dos dados;
		Usuario u = new Usuario();
		u.setEmail(email);
		u.setSenha(senha);
		u.setRole(role);
		usuarioRepository.save(u);
        Iterable<Usuario> listaUsuario = usuarioRepository.findAll();
        model.addAttribute("usuario", listaUsuario);
		return "visualizar";
	}
	@GetMapping("/all")
    public String setUser(@ModelAttribute Usuario usuario, Model model) {
        Iterable<Usuario> listaUsuario = usuarioRepository.findAll();
        model.addAttribute("usuario", listaUsuario);
        return "visualizar";
    }
	
}