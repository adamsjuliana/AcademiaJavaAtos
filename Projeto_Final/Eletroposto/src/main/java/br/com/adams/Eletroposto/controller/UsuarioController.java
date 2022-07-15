package br.com.adams.Eletroposto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.adams.Eletroposto.model.Usuario;
import br.com.adams.Eletroposto.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/add") /* PAGINA DE REGISTRO DE USUARIO*/
	public String addUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		   return "cadastrar";
		   }
	@PostMapping("/add") /* REGISTRO DE USUARIO*/
	public String salvaUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "cadastrar";
		}
		usuarioRepository.save(usuario);
		attributes.addFlashAttribute("mensagem", "Registro efetuado com sucesso!!");
		   return "redirect:/login";
}
	
	@GetMapping("/admin/all")
	public String listarUsuarios(Model model) {
	model.addAttribute("usuarios", usuarioRepository.findAll());
	return "/auth/admin/admin-lista-usuarios";
	
	}
	@GetMapping("/admin/del/{id}")
	public String delUsuario(@PathVariable("id") long id, Model model) {
		usuarioRepository.deleteById(id);
		return "redirect:/usuario/admin/all";
	}
	@GetMapping("/admin/edit/{id}")
	public String editUsuario(@PathVariable("id") long id, Model model) {
		Optional<Usuario> u = usuarioRepository.findById(id);
		Usuario usuario = u.get();
		model.addAttribute("usuario", usuario);
		return "/auth/admin/admin-editar-usuarios";
	}
	
	@PostMapping("/admin/edit/{id}")
	public String saveEditUsuario(@PathVariable("id") long id, @Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			usuario.setId(id);
			return "/auth/admin/admin-editar-usuarios";
		}
		usuarioRepository.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário alterado com sucesso!!");
		return "redirect:/usuario/admin/all";
	}
}
