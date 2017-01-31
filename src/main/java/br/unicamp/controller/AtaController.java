package br.unicamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Ata;
import br.unicamp.repository.AtaRepository;

@RestController
@RequestMapping("ata/v1/")
public class AtaController {

	@Autowired		
	private AtaRepository ataRepository;
	
	@RequestMapping(value="atas", method=RequestMethod.GET)
	public List<Ata> list(){
		//return AtaStub.list();
		return ataRepository.findAll();
	}

	@RequestMapping(value = "atas", method = RequestMethod.POST)
	public Ata create(@RequestBody Ata ata){
		//return AtaStub.create(ata);
		return ataRepository.save(ata);
	}

	@RequestMapping(value = "atas/{id}", method = RequestMethod.GET)
	public Ata get(@PathVariable Long id){
		//return AtaStub.get(id);
		return ataRepository.findOne(id);
	}

	@RequestMapping(value = "atas/{id}", method = RequestMethod.PUT)
	public Ata update(@PathVariable Long id, @RequestBody Ata ata){
		//return AtaStub.update(id, ata);
		return ataRepository.save(ata);
	}

	@RequestMapping(value = "atas/{id}", method = RequestMethod.DELETE)
	public Ata delete(@PathVariable Long id){
		
		ataRepository.delete(id);
		return null;
		//return AtaStub.delete(id);
	}

}
