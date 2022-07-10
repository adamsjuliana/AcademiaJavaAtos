package com.adams.ProjetoJ.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adams.ProjetoJ.Models.Usuario;
import com.adams.ProjetoJ.Repositories.UsuarioRepository;

@Controller
@RequestMapping("/")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/add")
	public String pagCadastroUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "cadastroUsuario";
	}
	@PostMapping("/add")
	public String addUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String cidade, @RequestParam String estado, @RequestParam String senha, @RequestParam String role, Model model) {
		Usuario u = new Usuario();
		u.setNome(nome);
		u.setEmail(email);
		u.setCidade(cidade);
		u.setEstado(estado);
		u.setSenha(senha);
		u.setRole(role);
		usuarioRepository.save(u);
		return "home";
	}
}
