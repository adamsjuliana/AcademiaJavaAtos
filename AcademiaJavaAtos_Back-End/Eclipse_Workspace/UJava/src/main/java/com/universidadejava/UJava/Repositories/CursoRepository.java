package com.universidadejava.UJava.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.universidadejava.UJava.Models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
