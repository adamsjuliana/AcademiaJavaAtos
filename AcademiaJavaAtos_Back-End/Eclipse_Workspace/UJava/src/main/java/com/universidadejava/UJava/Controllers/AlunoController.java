package com.universidadejava.UJava.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.universidadejava.UJava.Models.Aluno;
import com.universidadejava.UJava.Models.Curso;
import com.universidadejava.UJava.Repositories.AlunoRepository;
import com.universidadejava.UJava.Repositories.CursoRepository;

@RestController
public class AlunoController {
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private CursoRepository cursoRepository;

	@PostMapping("/alunos") // Grava um novo aluno no BD
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionarAluno(@RequestBody Aluno aluno) {
		alunoRepository.save(aluno);
	}

	@PostMapping("/aluno/{id}") // Adiciona um Curso a um aluno já cadastrado no BD
	@ResponseStatus(HttpStatus.OK)
	public void adicionarCursoAluno(@PathVariable Long id, @RequestBody Curso curso) {
		Aluno aluno = alunoRepository.findById(id).get();
		Curso c = cursoRepository.findById(curso.getId()).get();
		aluno.getCursos().add(c);
		alunoRepository.save(aluno);
	}

	@GetMapping("/alunos") // Lista os alunos cadastrados no BD
	public List<Aluno> listarAlunos() {
		return alunoRepository.findAll();
	}
}
