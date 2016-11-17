package br.unicamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
