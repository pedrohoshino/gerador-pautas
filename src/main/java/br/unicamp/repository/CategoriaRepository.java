package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	List<Categoria> findAll();
	
	Categoria findOne(Long id);
	
	Categoria getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	@SuppressWarnings("unchecked")
	Categoria save(Categoria categoria);
	
}
