package com.adams.exemploSprintJPARest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adams.exemploSprintJPARest.Models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
