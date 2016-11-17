package br.unicamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Usuario;
import br.unicamp.repository.UsuarioRepository;

@RestController
@RequestMapping("usuario/v1/")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "usuarios", method = RequestMethod.GET)
	public List<Usuario> list(){
		return usuarioRepository.findAll();
	}
}
