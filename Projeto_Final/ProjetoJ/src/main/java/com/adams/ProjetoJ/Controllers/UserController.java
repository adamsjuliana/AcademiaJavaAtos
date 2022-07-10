package com.adams.ProjetoJ.Controllers;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adams.ProjetoJ.Models.Agendamento;
import com.adams.ProjetoJ.Models.Usuario;
import com.adams.ProjetoJ.Repositories.AgendamentoRepository;
import com.adams.ProjetoJ.Repositories.UsuarioRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@GetMapping("/all") /* USUARIO VÊ SEUS AGENDAMENTOS */
	public String userAllAgendamentos(Model model, Principal principal) {
   List<Agendamento> listaAgendamento = agendamentoRepository.findAgendamentoByUsuarioUSER(principal.getName());
    model.addAttribute("agendamento", listaAgendamento);
    return "userAgendamentos";
	}	
	@GetMapping("/del/{id}") /* USUARIO DELETA SEUS AGENDAMENTOS */
    public String userDelAgendamento(@PathVariable Integer id, Principal principal, Model model) {
    agendamentoRepository.deleteById(id);
    List<Agendamento> listaAgendamento = agendamentoRepository.findAgendamentoByUsuarioUSER(principal.getName());
    model.addAttribute("agendamento", listaAgendamento);
    return "userAgendamentos";
    }
	
}