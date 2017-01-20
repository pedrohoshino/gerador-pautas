package br.unicamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Usuario;
import br.unicamp.repository.UsuarioRepository;;

@RestController
@RequestMapping("usuario/v1/")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "usuarios", method = RequestMethod.GET)
	public List<Usuario> list(){
		return usuarioRepository.findAll();
	}
	

	@RequestMapping(value = "usuarios", method = RequestMethod.POST)
	public Usuario create(@RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	@RequestMapping(value = "usuarios/{id}", method = RequestMethod.GET)
	public Usuario get(@PathVariable Long id){
		
		return usuarioRepository.findOne(id);
	}

	@RequestMapping(value = "usuarios/{id}", method = RequestMethod.PUT)
	public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario){
		

		return usuarioRepository.save(usuario);
	}

	@RequestMapping(value = "usuarios/{id}", method = RequestMethod.DELETE)
	public Usuario delete(@PathVariable Long id){
		
		usuarioRepository.delete(id);
		return null;
	}
}
