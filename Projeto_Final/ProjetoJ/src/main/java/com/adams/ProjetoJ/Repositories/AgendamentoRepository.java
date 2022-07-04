package com.adams.ProjetoJ.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

import com.adams.ProjetoJ.Models.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
	
	//@Query("Select * from agendamento where usuario_id=:id")
	//public User getUserById(@Param("Id") String id);
	
	@Query(value="select * from agendamento where dia=:dia and hora=:hora", nativeQuery = true)
	public Agendamento dataValida(String dia, String hora);
	
}
