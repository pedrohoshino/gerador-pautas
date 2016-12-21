package br.unicamp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Deliberacao;


@RestController
@RequestMapping("deliberacao/v1/")
public class DeliberacaoController {
	
	@RequestMapping(value="deliberacoes", method=RequestMethod.GET)
	public List<Deliberacao> list(){
		return DeliberacaoStub.list();
	}

	@RequestMapping(value = "deliberacoes", method = RequestMethod.POST)
	public Deliberacao create(@RequestBody Deliberacao deliberacao){
		return DeliberacaoStub.create(deliberacao);
	}

	@RequestMapping(value = "deliberacoes/{id}", method = RequestMethod.GET)
	public Deliberacao get(@PathVariable Long id){
		return DeliberacaoStub.get(id);
	}

	@RequestMapping(value = "deliberacoes/{id}", method = RequestMethod.PUT)
	public Deliberacao update(@PathVariable Long id, @RequestBody Deliberacao deliberacao){
		return DeliberacaoStub.update(id, deliberacao);
	}

	@RequestMapping(value = "deliberacoes/{id}", method = RequestMethod.DELETE)
	public Deliberacao delete(@PathVariable Long id){
		return DeliberacaoStub.delete(id);
	}

}
