package br.unicamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicamp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	
	@Query("select u from Usuario u order by u.login")
	List<Usuario> findAll();
	
	Usuario findOne(Long id);
	
	Usuario getOne(Long id);
	
	void delete(Long id);
	
	void flush();
	
	@SuppressWarnings("unchecked")
	Usuario save(Usuario usuario);

}
