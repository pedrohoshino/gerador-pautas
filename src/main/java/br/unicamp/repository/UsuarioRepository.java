package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
List<Usuario> findAll();
	
	Usuario findOne(Long id);
	
	Usuario getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	@SuppressWarnings("unchecked")
	Usuario save(Usuario usuario);

}
