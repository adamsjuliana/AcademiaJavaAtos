package com.eadams.JPARest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eadams.JPARest.Models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
}