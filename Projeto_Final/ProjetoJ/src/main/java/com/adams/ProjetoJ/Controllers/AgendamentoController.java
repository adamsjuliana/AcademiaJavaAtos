package com.adams.ProjetoJ.Controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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

import com.adams.ProjetoJ.Models.Agendamento;
import com.adams.ProjetoJ.Models.Usuario;
import com.adams.ProjetoJ.Repositories.AgendamentoRepository;
import com.adams.ProjetoJ.Repositories.UsuarioRepository;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/add")
	public String pagAddAgendamento(Model model) {
		model.addAttribute("agendamento", new Agendamento());
		return "agendar";
	}
	@PostMapping("/add")
	public String addAgendamento(@ModelAttribute Usuario usuario, @RequestParam String dia, @RequestParam String hora, Principal principal, Model model) {
		Agendamento a = new Agendamento();
    	Usuario u = usuarioRepository.findUsuarioLogado(principal.getName());
			a.setUsuario(u);
			a.setDia(dia);
			a.setHora(hora);
		agendamentoRepository.save(a);
		return "home";
	}

	}
