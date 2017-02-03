package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicamp.model.Ata;

public interface AtaRepository extends JpaRepository<Ata, Long> {

	
	@Query("select a from Ata a order by a.data, a.titulo")
	List<Ata> findAll();
	
	Ata findOne(Long id);
	
	Ata getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	@SuppressWarnings("unchecked")
	Ata save(Ata ata);
	
}
