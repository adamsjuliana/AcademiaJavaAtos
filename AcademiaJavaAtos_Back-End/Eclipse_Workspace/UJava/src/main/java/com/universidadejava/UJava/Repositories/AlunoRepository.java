package com.universidadejava.UJava.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.universidadejava.UJava.Models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
