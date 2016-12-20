package br.unicamp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Reuniao;


	
@RestController
@RequestMapping("reuniao/v1/")
public class ReuniaoController {
		
	@RequestMapping(value="reunioes", method=RequestMethod.GET)
	public List<Reuniao> list(){
		return ReuniaoStub.list();
	}
	
	@RequestMapping(value = "reunioes", method = RequestMethod.POST)
	public Reuniao create(@RequestBody Reuniao reuniao){
		return ReuniaoStub.create(reuniao);
	}
	
	@RequestMapping(value = "reunioes/{id}", method = RequestMethod.GET)
	public Reuniao get(@PathVariable Long id){
		return ReuniaoStub.get(id);
	}

	@RequestMapping(value = "reunioes/{id}", method = RequestMethod.PUT)
	public Reuniao update(@PathVariable Long id, @RequestBody Reuniao reuniao){
		return ReuniaoStub.update(id, reuniao);
	}

	@RequestMapping(value = "reunioes/{id}", method = RequestMethod.DELETE)
	public Reuniao delete(@PathVariable Long id){
		return ReuniaoStub.delete(id);
	}

}
