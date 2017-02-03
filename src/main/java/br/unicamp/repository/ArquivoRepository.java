package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicamp.model.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

	@Query("select a from Arquivo a order by a.titulo, a.nome, a.tipo")
	List<Arquivo> findAll();
	
	Arquivo findOne(Long id);
	
	Arquivo getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	@SuppressWarnings("unchecked")
	Arquivo save(Arquivo arquivo);
	
}
