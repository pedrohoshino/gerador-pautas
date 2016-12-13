package br.unicamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
