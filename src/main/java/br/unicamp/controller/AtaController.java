package br.unicamp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Ata;

@RestController
@RequestMapping("ata/v1/")
public class AtaController {

	@RequestMapping(value="atas", method=RequestMethod.GET)
	public List<Ata> list(){
		return AtaStub.list();
	}

	@RequestMapping(value = "atas", method = RequestMethod.POST)
	public Ata create(@RequestBody Ata ata){
		return AtaStub.create(ata);
	}

	@RequestMapping(value = "atas/{id}", method = RequestMethod.GET)
	public Ata get(@PathVariable Long id){
		return AtaStub.get(id);
	}

	@RequestMapping(value = "atas/{id}", method = RequestMethod.PUT)
	public Ata update(@PathVariable Long id, @RequestBody Ata ata){
		return AtaStub.update(id, ata);
	}

	@RequestMapping(value = "atas/{id}", method = RequestMethod.DELETE)
	public Ata delete(@PathVariable Long id){
		return AtaStub.delete(id);
	}

}
