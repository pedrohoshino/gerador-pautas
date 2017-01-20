package br.unicamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Reuniao;
import br.unicamp.repository.ReuniaoRepository;


	
@RestController
@RequestMapping("reuniao/v1/")
public class ReuniaoController {
	
	@Autowired		
	private ReuniaoRepository reuniaoRepository;
	
	@RequestMapping(value="reunioes", method=RequestMethod.GET)
	public List<Reuniao> list(){
		
		return reuniaoRepository.findAll();
		//return ReuniaoStub.list();
	}
	
	@RequestMapping(value = "reunioes", method = RequestMethod.POST)
	public Reuniao create(@RequestBody Reuniao reuniao){
		//return ReuniaoStub.create(reuniao);
		return reuniaoRepository.save(reuniao);
	}
	
	@RequestMapping(value = "reunioes/{id}", method = RequestMethod.GET)
	public Reuniao get(@PathVariable Long id){
		
		return reuniaoRepository.findOne(id);
		//return ReuniaoStub.get(id);
	}

	@RequestMapping(value = "reunioes/{id}", method = RequestMethod.PUT)
	public Reuniao update(@PathVariable Long id, @RequestBody Reuniao reuniao){
		
		//reuniao.setId(id);
		return reuniaoRepository.save(reuniao);
		//return ReuniaoStub.update(id, reuniao);
	}

	@RequestMapping(value = "reunioes/{id}", method = RequestMethod.DELETE)
	public Reuniao delete(@PathVariable Long id){
		
		reuniaoRepository.delete(id);
		return null;
		//return ReuniaoStub.delete(id);
	}

}
