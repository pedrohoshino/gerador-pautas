package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.model.Participante;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

	List<Participante> findAll();
	
	Participante findOne(Long id);
	
	Participante getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	@SuppressWarnings("unchecked")
	Participante save(Participante participante);
	
}
