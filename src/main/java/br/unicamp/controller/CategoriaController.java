package br.unicamp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Categoria;

@RestController
@RequestMapping("categoria/v1/")
public class CategoriaController {
	
	@RequestMapping(value="categorias", method=RequestMethod.GET)
	public List<Categoria> list(){
		return CategoriaStub.list();
	}

	@RequestMapping(value = "categorias", method = RequestMethod.POST)
	public Categoria create(@RequestBody Categoria categoria){
		return CategoriaStub.create(categoria);
	}

	@RequestMapping(value = "categorias/{id}", method = RequestMethod.GET)
	public Categoria get(@PathVariable Long id){
		return CategoriaStub.get(id);
	}

	@RequestMapping(value = "categorias/{id}", method = RequestMethod.PUT)
	public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria){
		return CategoriaStub.update(id, categoria);
	}

	@RequestMapping(value = "categorias/{id}", method = RequestMethod.DELETE)
	public Categoria delete(@PathVariable Long id){
		return CategoriaStub.delete(id);
	}

}
