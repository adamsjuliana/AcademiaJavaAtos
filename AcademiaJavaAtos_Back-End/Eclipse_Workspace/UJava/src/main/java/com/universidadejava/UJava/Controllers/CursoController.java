package com.universidadejava.UJava.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.universidadejava.UJava.Models.Curso;
import com.universidadejava.UJava.Repositories.CursoRepository;

@RestController
public class CursoController {
	@Autowired
	private CursoRepository cursoRepository;

	@PostMapping("/cursos") // Grava um novo curso no BD
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionarCurso(@RequestBody Curso curso) {
		cursoRepository.save(curso);

	}

	@GetMapping("/cursos") // Lista os cursos já cadastrados no BD
	public List<Curso> listarCursos() {
		return cursoRepository.findAll();
	}
}
