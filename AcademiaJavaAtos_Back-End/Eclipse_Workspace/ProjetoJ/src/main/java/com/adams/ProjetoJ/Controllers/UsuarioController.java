package com.adams.ProjetoJ.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/")
	public String pagHome() {
		return "home";
	}
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
	@GetMapping("/all")
    public String listarUsuarios(@ModelAttribute Usuario usuario, Model model) {
        Iterable<Usuario> listaUsuario = usuarioRepository.findAll();
        model.addAttribute("usuario", listaUsuario);
        return "adminListaUsuarios";
    }
	@GetMapping("/delete/{id}")
    public String delUsuario(@PathVariable Integer id, Model model) {
    	usuarioRepository.deleteById(id);
        Iterable<Usuario> listaUsuario = usuarioRepository.findAll();
        model.addAttribute("usuario", listaUsuario);
    	return "adminListaUsuarios";
    }
    @GetMapping("/update/{id}")
    public String altUser(@PathVariable Integer id, Model model) {
    	Usuario u = usuarioRepository.findById(id).get();
    	model.addAttribute("usuario",u);
    	return "adminEditarUsuarios";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute Usuario novoUsuario, Model model) {
    	Usuario u = usuarioRepository.findById(novoUsuario.getId()).get();
    	u.setId(novoUsuario.getId());
    	u.setNome(novoUsuario.getNome());
    	u.setEmail(novoUsuario.getEmail());
    	u.setCidade(novoUsuario.getCidade());
    	u.setEstado(novoUsuario.getEstado());
    	u.setEmail(novoUsuario.getEmail());
    	u.setRole(novoUsuario.getRole());
    	usuarioRepository.save(u);
        Iterable<Usuario> listaUsuario = usuarioRepository.findAll();
        model.addAttribute("usuario", listaUsuario);
    	return "adminListaUsuarios";
    }
}
