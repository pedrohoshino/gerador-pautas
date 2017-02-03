package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicamp.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	
	@Query("select i from Item i order by i.categoria.titulo, i.ordem")
	List<Item> findAll();
	
	Item findOne(Long id);
	
	Item getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	@SuppressWarnings("unchecked")
	Item save(Item item);
	
}
