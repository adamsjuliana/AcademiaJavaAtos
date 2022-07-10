package com.adams.ProjetoJ.Controllers;


import java.security.Principal;
import java.util.List;

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
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@GetMapping("/all") /** LISTA TODOS AGENDAMENTOS **/
    public String adminAllAgendamento(@ModelAttribute Agendamento agendamento, Model model) {
        List<Agendamento> listaAgendamento = agendamentoRepository.findAll();
        model.addAttribute("agendamento", listaAgendamento);
        return "adminListaAgendamentos";
    }
	@GetMapping("/today") /** LISTA AGENDAMENTOS HOJE **/
    public String adminTodayAgendamento(@RequestParam String dia, @ModelAttribute Agendamento agendamento, Model model) {
        List<Agendamento> listaAgendamento = agendamentoRepository.findByToday(dia);
        model.addAttribute("agendamento", listaAgendamento);
        return "adminListaAgendamentosHoje";
    }
	@GetMapping("/deltoday/{id}") /** LISTA AGENDAMENTOS HOJE **/
    public String adminDelTodayAgendamento(@PathVariable Integer id, Model model) {
    	agendamentoRepository.deleteById(id);
        return "home";
    }
	@GetMapping("/del/{id}") /** DELETAR AGENDAMENTO **/
    public String adminDelAgendamento(@PathVariable Integer id, Model model) {
    	agendamentoRepository.deleteById(id);
        List<Agendamento> listaAgendamento = agendamentoRepository.findAll();
        model.addAttribute("agendamento", listaAgendamento);
    	return "adminListaAgendamentos";
    }			
	
	@GetMapping("/each/{id}") /** LISTA AGENDAMENTO POR CLIENTE **/
    public String adminAgendamentoPorUSER(@PathVariable Integer id, Model model) {
    List<Agendamento> listaAgendamento = agendamentoRepository.findByIDCLIENTE(id);
    model.addAttribute("agendamento", listaAgendamento);
    return "adminAgendamentoPorCliente";
    }
	@GetMapping("/alluser") /** LISTA TODOS USUARIOS **/
    public String listarUsuarios(@ModelAttribute Usuario usuario, Model model) {
        Iterable<Usuario> listaUsuario = usuarioRepository.findAll();
        model.addAttribute("usuario", listaUsuario);
        return "adminListaUsuarios";
    }
	@GetMapping("/deluser/{id}") /** DELETA USUARIO **/
    public String delUsuario(@PathVariable Integer id, Model model) {
    	usuarioRepository.deleteById(id);
        Iterable<Usuario> listaUsuario = usuarioRepository.findAll();
        model.addAttribute("usuario", listaUsuario);
    	return "adminListaUsuarios";
    }
    @GetMapping("/upuser/{id}") /** PAGINA PARA EDIÇÃO DE USUARIO **/
    public String altUser(@PathVariable Integer id, Model model) {
    	Usuario u = usuarioRepository.findById(id).get();
    	model.addAttribute("usuario", u);
    	return "adminEditarUsuarios";
    }
    @PostMapping("/upuser") /** EDITA O USUARIO **/
    public String updateUser(@ModelAttribute Usuario novoUsuario, Model model) {
    	Usuario u = usuarioRepository.findById(novoUsuario.getId()).get();
    	u.setId(novoUsuario.getId());
    	u.setNome(novoUsuario.getNome());
    	u.setEmail(novoUsuario.getEmail());
    	u.setCidade(novoUsuario.getCidade());
    	u.setEstado(novoUsuario.getEstado());
    	u.setRole(novoUsuario.getRole());
    	usuarioRepository.save(u);
        Iterable<Usuario> listaUsuario = usuarioRepository.findAll();
        model.addAttribute("usuario", listaUsuario);
    	return "adminListaUsuarios";
    }
}