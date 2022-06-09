package com.adams.cadastro.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.adams.cadastro.model.Pessoa;

@Controller
public class pessoasController {
	ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
	
	@GetMapping("/cadastro")
	public String registrarPessoas(Model model){
		model.addAttribute("pessoa", new Pessoa());
		return "cadastro";
	}
	@PostMapping("/cadastro")
	public String addPessoa(@ModelAttribute Pessoa pessoa, Model model){
		lista.add(pessoa);
		model.addAttribute("listaPessoa", lista);
		return "lista";
	}


}
