package com.JpaAnnotation.BancoJava.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.JpaAnnotation.BancoJava.Models.Filial;
import com.JpaAnnotation.BancoJava.Repositories.FilialRepository;

@RestController
public class ControllerFilial {
	@Autowired
	private FilialRepository filialRepository;

	@PostMapping("/filiais")//salva uma nova filial
	@ResponseStatus(HttpStatus.CREATED)
	public Filial adicionarFilial(@RequestBody Filial filial) {
		filialRepository.save(filial);
		return filial;
	}

	@GetMapping("/filiais")//lista as filiais
	public List<Filial> listarFiliais() {
		return filialRepository.findAll();
	}
}
