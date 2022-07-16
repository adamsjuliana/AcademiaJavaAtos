package br.com.adams.Eletroposto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.adams.Eletroposto.model.Papel;
import br.com.adams.Eletroposto.model.Usuario;
import br.com.adams.Eletroposto.repository.PapelRepository;
import br.com.adams.Eletroposto.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private BCryptPasswordEncoder criptografia;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PapelRepository papelRepository;

	@GetMapping("/add") /* PAGINA DE REGISTRO DE USUARIO */
	public String addUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "cadastrar";
	}

	@PostMapping("/add") /* REGISTRO DE USUARIO */
	public String salvaUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes,
			Model model) {
		if (result.hasErrors()) {
			return "cadastrar";
		}
		Usuario usr = usuarioRepository.findByUsername(usuario.getUsername());
		if (usr != null) {
			model.addAttribute("usernameExiste", "Username já existente.");
			return "cadastrar";
		}

		Papel papel = papelRepository.findByPapel("USER");
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(papel);
		usuario.setPapeis(papeis);

		
		String senhaCript = criptografia.encode(usuario.getPassword());
		usuario.setPassword(senhaCript);
		
		usuario.setAtivo(true);
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
	public String saveEditUsuario(@PathVariable("id") long id, @Valid Usuario usuario, BindingResult result,
			RedirectAttributes attributes, Model model) {
		if (result.hasErrors()) {
			usuario.setId(id);
			return "/auth/admin/admin-editar-usuarios";
		}
		Usuario usr = usuarioRepository.findByUsername(usuario.getUsername());
		if (usr != null) {
			model.addAttribute("usernameExiste", "Username já existente.");
			return "/auth/admin/admin-editar-usuarios";
		}
		
		usuarioRepository.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário alterado com sucesso!!");
		return "redirect:/usuario/admin/all";
	}

	@GetMapping("/admin/editPapel/{id}")
	public String editPapelUsuario(@PathVariable("id") long id, Model model) {
		Optional<Usuario> u = usuarioRepository.findById(id);
		Usuario usuario = u.get();
		model.addAttribute("usuario", usuario);
		model.addAttribute("listaPapeis", papelRepository.findAll());
		return "/auth/admin/admin-editar-usuarios-papel";
	}

	@PostMapping("/admin/editPapel/{id}")
	public String atribuirPapel(@PathVariable("id") long idUsuario,
			@RequestParam(value = "pps", required = false) int[] pps, Usuario usuario, RedirectAttributes attributes) {
		if (pps == null) {
			usuario.setId(idUsuario);
			attributes.addFlashAttribute("mensagem", "Pelo menos um papel deve ser informado.");
			return "redirect:/usuario/admin/editPapel/" + idUsuario;
		} else {
//Obtém a lista de papéis selecionada pelo usuário do banco
			List<Papel> papeis = new ArrayList<Papel>();
			for (int i = 0; i < pps.length; i++) {
				long idPapel = pps[i];
				Optional<Papel> papelOptional = papelRepository.findById(idPapel);
				if (papelOptional.isPresent()) {
					Papel papel = papelOptional.get();
					papeis.add(papel);
				}
			}
			Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
			if (usuarioOptional.isPresent()) {
				Usuario usr = usuarioOptional.get();
				usr.setPapeis(papeis); // relaciona papéis ao usuário
				usr.setAtivo(usuario.isAtivo());
				usuarioRepository.save(usr);
	        }

		}
		return "redirect:/usuario/admin/all";

	}
}
