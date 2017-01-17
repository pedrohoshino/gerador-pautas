package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findAll();
	
	Item findOne(Long id);
	
	Item getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	@SuppressWarnings("unchecked")
	Item save(Item item);
	
}
