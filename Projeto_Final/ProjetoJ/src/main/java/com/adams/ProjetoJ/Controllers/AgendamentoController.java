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
	public String pagCadastroUsuario(Model model) {
		model.addAttribute("agendamento", new Agendamento());
		return "agendar";
	}
	@PostMapping("/add")
	public String addUsuario(@ModelAttribute Usuario usuario, @RequestParam String dia, @RequestParam String hora, Principal principal, Model model) {
		Agendamento a = new Agendamento();
    	Usuario u = usuarioRepository.findUsuarioLogado(principal.getName());
			a.setUsuario(u);
			a.setDia(dia);
			a.setHora(hora);
		agendamentoRepository.save(a);
		return "home";
	} 	
		@GetMapping("/alluser")
		public String listarAgendamentosUSER(Model model, Principal principal) {
       List<Agendamento> listaAgendamento = agendamentoRepository.findAgendamentoByUsuarioUSER(principal.getName());
        model.addAttribute("agendamento", listaAgendamento);
        return "meusAgendamentos";
		}	
		@GetMapping("/deleteUSER/{id}")
	    public String delAgendamentoUSER(@PathVariable Integer id, Principal principal, Model model) {
	    agendamentoRepository.deleteById(id);
	    List<Agendamento> listaAgendamento = agendamentoRepository.findAgendamentoByUsuarioUSER(principal.getName());
	    model.addAttribute("agendamento", listaAgendamento);
	    return "meusAgendamentos";
	    }
				/** ADMINISTRADOR **/
	@GetMapping("/all")
    public String listarAgendamentosADMIN(@ModelAttribute Agendamento agendamento, Model model) {
        List<Agendamento> listaAgendamento = agendamentoRepository.findAll();
        model.addAttribute("agendamento", listaAgendamento);
        return "adminListaAgendamentos";
    }

	@GetMapping("/delete/{id}")
    public String delAgendamentoADMIN(@PathVariable Integer id, Model model) {
    	agendamentoRepository.deleteById(id);
        List<Agendamento> listaAgendamento = agendamentoRepository.findAll();
        model.addAttribute("agendamento", listaAgendamento);
    	return "adminListaAgendamentos";
    }			/** ADMINISTRADOR **/
	
	@GetMapping("/listaagendamentoporcliente/{id}")
    public String listaAgendamentoPorUSER(@PathVariable Integer id, Principal principal, Model model) {
    List<Agendamento> listaAgendamento = agendamentoRepository.findByIDCLIENTE(id);
    model.addAttribute("agendamento", listaAgendamento);
    System.out.println(listaAgendamento);
    return "listarAgendamentoPorCliente";
    }
	}
