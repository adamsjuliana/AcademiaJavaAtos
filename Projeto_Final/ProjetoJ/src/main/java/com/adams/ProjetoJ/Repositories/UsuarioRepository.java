package com.adams.ProjetoJ.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adams.ProjetoJ.Models.Agendamento;
import com.adams.ProjetoJ.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	/*TA FUNCIONANDO NAO MEXER DE JEITO NENHUM*/
	@Query("SELECT u FROM Usuario u WHERE u.email = :username")
	Usuario findUsuarioLogado(@Param("username") String username);

}