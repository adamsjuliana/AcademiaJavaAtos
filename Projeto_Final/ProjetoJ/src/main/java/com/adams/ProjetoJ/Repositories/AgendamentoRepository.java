package com.adams.ProjetoJ.Repositories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

import com.adams.ProjetoJ.Models.Agendamento;
import com.adams.ProjetoJ.Models.Usuario;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
	
	//	@Query("Select p from agendamento p where usuario_id=:id")
	//User getUserById(@Param("Id") String id);
	
	//@Query(value="select * from agendamento where dia=:dia and hora=:hora", nativeQuery = true)
	//Agendamento dataValida(String dia, String hora);
	
	//@Query("SELECT p FROM Agendamento p JOIN Usuario u WHERE u.email= :username")
	//List<Agendamento> findAllByUsuario(@Param("username") String username);
	
	/*TA FUNCIONANDO NAO MEXER DE JEITO NENHUM*/
	@Query("select p from Agendamento p join p.usuario u where u.email = :username")
	List<Agendamento> findAgendamentoByUsuarioUSER(@Param("username") String username);

	@Query("select p from Agendamento p join p.usuario u where u.id = :id")
	List<Agendamento> findByIDCLIENTE(@Param("id") Integer id);

	@Query("select p from Agendamento p where p.dia = :dia order by p.hora")
	List<Agendamento> findByToday(@Param("dia") String dia);
}