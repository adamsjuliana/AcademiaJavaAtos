package br.com.adams.Eletroposto.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.adams.Eletroposto.model.Agendamento;
import br.com.adams.Eletroposto.model.Usuario;
import br.com.adams.Eletroposto.repository.AgendamentoRepository;
import br.com.adams.Eletroposto.repository.UsuarioRepository;


@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping("/meus") /* USUARIO VÊ SEUS AGENDAMENTOS */
	public String userAllAgendamentos(Model model, Principal principal) {
   List<Agendamento> listaAgendamento = agendamentoRepository.findAgendamentoByUsuarioUSER(principal.getName());
    model.addAttribute("agendamento", listaAgendamento);
    return "meusAgendamentos";
	}	
	
	@GetMapping("/update/{id}") /* USUARIO AGENDA */
	public String updateAgendamentos(@PathVariable("id") Long id, Model model, Principal principal) {
	//System.out.println(id);
	//System.out.println(principal.getName());
	agendamentoRepository.findAgendamentoAgendamento(principal.getName(), id);
	List<Agendamento> listaAgendamento = agendamentoRepository.findAgendamentoByUsuarioUSER(principal.getName());
	model.addAttribute("agendamento", listaAgendamento);
	return "meusAgendamentos";
	}

}
