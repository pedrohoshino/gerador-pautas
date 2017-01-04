package br.unicamp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Participante;

@RestController
@RequestMapping("participante/v1/")
public class ParticipanteController {
	
	@RequestMapping(value="participantes", method=RequestMethod.GET)
	public List<Participante> list(){
		return ParticipanteStub.list();
	}

	@RequestMapping(value = "participantes", method = RequestMethod.POST)
	public Participante create(@RequestBody Participante participante){
		return ParticipanteStub.create(participante);
	}

	@RequestMapping(value = "participantes/{id}", method = RequestMethod.GET)
	public Participante get(@PathVariable Long id){
		return ParticipanteStub.get(id);
	}

	@RequestMapping(value = "participantes/{id}", method = RequestMethod.PUT)
	public Participante update(@PathVariable Long id, @RequestBody Participante participante){
		return ParticipanteStub.update(id, participante);
	}

	@RequestMapping(value = "participantes/{id}", method = RequestMethod.DELETE)
	public Participante delete(@PathVariable Long id){
		return ParticipanteStub.delete(id);
	}


}
