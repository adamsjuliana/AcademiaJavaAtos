package com.JpaAnnotation.BancoJava.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JpaAnnotation.BancoJava.Models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
	@Query("select a from Conta a where a.numeroConta = ?1")
    public Conta getConta(Long numeroConta);
}
