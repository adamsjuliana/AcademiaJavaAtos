package com.adams.ProjetoJ.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

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
	public String pagCadastroUsuario(Model model) {
		model.addAttribute("agendamento", new Agendamento());
		return "agendar";
	}
	@PostMapping("/add")
	public String addUsuario(@RequestParam Usuario usuario, @RequestParam String dia, @RequestParam String hora, Principal principal, Model model) {
		Agendamento a = new Agendamento();
			a.setUsuario(usuario);
			a.setDia(dia);
			a.setHora(hora);
		agendamentoRepository.save(a);
		return "home";
	} 	
	@GetMapping("/all")
    public String listarAgendamentosADMIN(@ModelAttribute Agendamento agendamento, Model model) {
        Iterable<Agendamento> listaAgendamento = agendamentoRepository.findAll();
        model.addAttribute("agendamento", listaAgendamento);
        return "adminListaAgendamentos";
    }
	@GetMapping("/delete/{id}")
    public String delAgendamentoADMIN(@PathVariable Integer id, Model model) {
    	agendamentoRepository.deleteById(id);
        Iterable<Agendamento> listaAgendamento = agendamentoRepository.findAll();
        model.addAttribute("agendamento", listaAgendamento);
    	return "adminListaAgendamentos";
    }
	}
