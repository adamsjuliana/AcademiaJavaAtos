package com.adams.ProjetoJ.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adams.ProjetoJ.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
