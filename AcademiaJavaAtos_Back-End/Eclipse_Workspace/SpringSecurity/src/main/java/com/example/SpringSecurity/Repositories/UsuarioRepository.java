package com.example.SpringSecurity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringSecurity.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

}
