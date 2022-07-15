package br.com.adams.Eletroposto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adams.Eletroposto.model.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {
	
	Papel findByPapel(String papel);
}
