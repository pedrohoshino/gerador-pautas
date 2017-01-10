package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.model.Ata;

public interface AtaRepository extends JpaRepository<Ata, Long> {

	List<Ata> findAll();
	
	Ata findOne(Long id);
	
	Ata getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	@SuppressWarnings("unchecked")
	Ata save(Ata ata);
	
}
