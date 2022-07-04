package com.universidadejava.UJava;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.universidadejava.UJava.Models.Aluno;
import com.universidadejava.UJava.Models.Curso;
import com.universidadejava.UJava.Repositories.AlunoRepository;
import com.universidadejava.UJava.Repositories.CursoRepository;

@SpringBootApplication
public class UJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UJavaApplication.class, args);
	}

	@Bean//Bean para adicionar dados as tabelas alunos e cursos ao rodar  a aplicação
	public CommandLineRunner mappingDemo(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
		return args -> {

			// cria um novo aluno
			Aluno aluno = new Aluno(null, "Lucas Alberto");

			// salva o novo aluno no BD
			alunoRepository.save(aluno);

			// cria novos cursos
			Curso c1 = new Curso(null, "IA", 1500);
			Curso c2 = new Curso(null, "BD I", 1200);
			Curso c3 = new Curso(null, "WEB", 500);

			// salva cursos no BD
			cursoRepository.saveAll(Arrays.asList(c1, c2, c3));

			// vincula os cursos ao aluno
			aluno.getCursos().addAll(Arrays.asList(c1, c2, c3));

			// atualiza o aluno após a adiçao dos cursos a entidade
			alunoRepository.save(aluno);
		};
	}
}
