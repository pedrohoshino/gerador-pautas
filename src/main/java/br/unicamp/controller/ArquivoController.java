package br.unicamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Arquivo;
import br.unicamp.repository.ArquivoRepository;


	
@RestController
@RequestMapping("arquivo/v1/")
public class ArquivoController {
	
	@Autowired		
	private ArquivoRepository arquivoRepository;
	
	@RequestMapping(value="arquivos", method=RequestMethod.GET)
	public List<Arquivo> list(){
		
		return arquivoRepository.findAll();
		//return ReuniaoStub.list();
	}
	
	@RequestMapping(value = "arquivos", method = RequestMethod.POST)
	public Arquivo create(@RequestBody Arquivo arquivo){
		//return ReuniaoStub.create(reuniao);
		return arquivoRepository.save(arquivo);
	}
	
	@RequestMapping(value = "arquivos/{id}", method = RequestMethod.GET)
	public Arquivo get(@PathVariable Long id){
		
		return arquivoRepository.findOne(id);
		//return ReuniaoStub.get(id);
	}

	@RequestMapping(value = "arquivos/{id}", method = RequestMethod.PUT)
	public Arquivo update(@PathVariable Long id, @RequestBody Arquivo arquivo){
		
		//reuniao.setId(id);
		return arquivoRepository.save(arquivo);
		//return ReuniaoStub.update(id, reuniao);
	}

	@RequestMapping(value = "arquivos/{id}", method = RequestMethod.DELETE)
	public Arquivo delete(@PathVariable Long id){
		
		arquivoRepository.delete(id);
		return null;
		//return ReuniaoStub.delete(id);
	}

}
