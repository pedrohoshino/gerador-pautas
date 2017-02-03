package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicamp.model.Reuniao;

public interface ReuniaoRepository extends JpaRepository<Reuniao, Long> {

	
	@Query("select r from Reuniao r order by r.data, r.hora, r.titulo")
	List<Reuniao> findAll();
	
	Reuniao findOne(Long id);
	
	Reuniao getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	
	@SuppressWarnings("unchecked")
	Reuniao save(Reuniao reuniao);
	
	
}
