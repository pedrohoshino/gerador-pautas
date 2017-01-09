package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.model.Reuniao;

public interface ReuniaoRepository extends JpaRepository<Reuniao, Long> {

	List<Reuniao> findAll();
	
	Reuniao findOne(Long id);
	
	Reuniao getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	
	@SuppressWarnings("unchecked")
	Reuniao save(Reuniao reuniao);
	
	
}
