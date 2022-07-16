package br.com.adams.Eletroposto.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.adams.Eletroposto.model.Agendamento;

@Repository
@Transactional
public interface AgendamentoRepository extends JpaRepository<Agendamento, String>  {

	@Query(value = "SELECT * from Agendamento a WHERE a.usuario_id IS NULL AND a.data > :now", nativeQuery = true)
	List<Agendamento> findByIdData(@Param("now") String now);
	
	@Modifying
	@Query(value = "insert ignore into Agendamento (data, usuario_id) values (:currdatestr, null)", nativeQuery = true)
	void saveData(@Param("currdatestr") String currdatestr);

	@Query(value = "SELECT * from Agendamento WHERE usuario_id IS NOT NULL AND data > :now", nativeQuery = true)
	List<Agendamento> findAllAgendamentos(@Param("now")String now);
	
	@Query("select p from Agendamento p where p.usuario_id = :username")
	List<Agendamento> findAgendamentoByUsuarioUSER(@Param("username") String username);

	@Modifying
	@Query(value = "UPDATE Agendamento p SET p.usuario_id = :username WHERE p.id = :id", nativeQuery = true)
	void findAgendamentoAgendamento(@Param("username") String username, @Param("id") Long id);

	@Modifying
	@Query(value = "UPDATE Agendamento p SET p.usuario_id = :username WHERE p.id = :id", nativeQuery = true)
	void delAgendamento(@Param("username") String username, @Param("id") Long id);

}
