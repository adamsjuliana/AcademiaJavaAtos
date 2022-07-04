package com.JpaAnnotation.BancoJava.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JpaAnnotation.BancoJava.Models.Filial;

public interface FilialRepository extends JpaRepository<Filial, Long>{
	@Query("select a from Filial a where a.codigo = ?1")
    public Filial getFilial(Long codigoFilial);
}
