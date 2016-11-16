package br.unicamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
