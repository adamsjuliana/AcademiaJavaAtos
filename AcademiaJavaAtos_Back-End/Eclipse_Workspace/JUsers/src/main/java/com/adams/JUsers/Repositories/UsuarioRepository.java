package com.adams.JUsers.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adams.JUsers.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

}