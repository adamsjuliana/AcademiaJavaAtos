package com.AcademiaJPARest.AcademiaJpaeRest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AcademiaJPARest.AcademiaJpaeRest.Models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
