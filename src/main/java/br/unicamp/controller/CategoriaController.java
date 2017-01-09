package br.unicamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Categoria;
import br.unicamp.repository.CategoriaRepository;



@RestController
@RequestMapping("categoria/v1/")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@RequestMapping(value="categorias", method=RequestMethod.GET)
	public List<Categoria> list(){
		
		return categoriaRepository.findAll();
		//return CategoriaStub.list();
	}

	@RequestMapping(value = "categorias", method = RequestMethod.POST)
	public Categoria create(@RequestBody Categoria categoria){
		
		return categoriaRepository.save(categoria);
		//return CategoriaStub.create(categoria);
	}

	@RequestMapping(value = "categorias/{id}", method = RequestMethod.GET)
	public Categoria get(@PathVariable Long id){
		
		return categoriaRepository.findOne(id);
		//return CategoriaStub.get(id);
	}

	@RequestMapping(value = "categorias/{id}", method = RequestMethod.PUT)
	public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria){
		
		return categoriaRepository.save(categoria);
		//return CategoriaStub.update(id, categoria);
	}

	@RequestMapping(value = "categorias/{id}", method = RequestMethod.DELETE)
	public Categoria delete(@PathVariable Long id){
		
		
		categoriaRepository.delete(id);
		return null;
		//return CategoriaStub.delete(id);
	}

}
