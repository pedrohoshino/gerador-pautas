package br.unicamp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Participante;
import br.unicamp.repository.ParticipanteRepository;

@RestController
@RequestMapping("participante/v1/")
public class ParticipanteController {
	
	ParticipanteRepository participanteRepository;
	
	@RequestMapping(value="participantes", method=RequestMethod.GET)
	public List<Participante> list(){
		//return ParticipanteStub.list();
		return participanteRepository.findAll();
	}

	@RequestMapping(value = "participantes", method = RequestMethod.POST)
	public Participante create(@RequestBody Participante participante){
		//return ParticipanteStub.create(participante);
		return participanteRepository.save(participante);
	}

	@RequestMapping(value = "participantes/{id}", method = RequestMethod.GET)
	public Participante get(@PathVariable Long id){
		//return ParticipanteStub.get(id);
		return participanteRepository.findOne(id);
	}

	@RequestMapping(value = "participantes/{id}", method = RequestMethod.PUT)
	public Participante update(@PathVariable Long id, @RequestBody Participante participante){
		//return ParticipanteStub.update(id, participante);
		return participanteRepository.save(participante);
	}

	@RequestMapping(value = "participantes/{id}", method = RequestMethod.DELETE)
	public Participante delete(@PathVariable Long id){
		//return ParticipanteStub.delete(id);
		participanteRepository.delete(id);
		return null;
	}


}
