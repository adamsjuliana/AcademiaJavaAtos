package br.com.adams.Eletroposto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adams.Eletroposto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByUsername(String username);
}
