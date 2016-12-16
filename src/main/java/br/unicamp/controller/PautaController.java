package br.unicamp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Pauta;

@RestController
@RequestMapping("pauta/v1/")
public class PautaController {
	
	@RequestMapping(value="pautas", method=RequestMethod.GET)
	public List<Pauta> list(){
		return PautaStub.list();
	}
	
	@RequestMapping(value = "pautas", method = RequestMethod.POST)
	public Pauta create(@RequestBody Pauta pauta){
		return PautaStub.create(pauta);
	}
	
	@RequestMapping(value = "pautas/{id}", method = RequestMethod.GET)
	public Pauta get(@PathVariable Long id){
		return PautaStub.get(id);
	}

	@RequestMapping(value = "pautas/{id}", method = RequestMethod.PUT)
	public Pauta update(@PathVariable Long id, @RequestBody Pauta pauta){
		return PautaStub.update(id, pauta);
	}

	@RequestMapping(value = "pautas/{id}", method = RequestMethod.DELETE)
	public Pauta delete(@PathVariable Long id){
		return PautaStub.delete(id);
	}

}
