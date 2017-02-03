package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.unicamp.model.ReuniaoParticipantes;

public interface ReuniaoParticipantesRepository extends JpaRepository<ReuniaoParticipantes, Long> {
	
	@Query("select r from ReuniaoParticipantes r order by r.participante.nome, r.participante.sobrenome, r.participante.tipo, r.tipoParticipacao")
	List<ReuniaoParticipantes> findAll();
		
	@Query("select r from ReuniaoParticipantes r where r.participante.id = :idParticipante order by r.participante.nome, r.participante.sobrenome, r.participante.tipo, r.tipoParticipacao")
	List<ReuniaoParticipantes> findAllParticipantes(@Param("idParticipante") Long idParticipante);
	
	
	@Query("select r from ReuniaoParticipantes r where r.reuniao.id = :idReuniao order by r.participante.nome, r.participante.sobrenome, r.participante.tipo, r.tipoParticipacao")
	List<ReuniaoParticipantes> findAllReunioes(@Param("idReuniao") Long idReuniao);
	
	ReuniaoParticipantes findOne(Long id);
	
	ReuniaoParticipantes getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	@SuppressWarnings("unchecked")
	ReuniaoParticipantes save(ReuniaoParticipantes reniaoParticipantes);
	
}
