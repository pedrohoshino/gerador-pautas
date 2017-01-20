package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.model.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

	List<Arquivo> findAll();
	
	Arquivo findOne(Long id);
	
	Arquivo getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	@SuppressWarnings("unchecked")
	Arquivo save(Arquivo arquivo);
	
}
