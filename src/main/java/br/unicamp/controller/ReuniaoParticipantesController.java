package br.unicamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.ReuniaoParticipantes;
import br.unicamp.repository.ReuniaoParticipantesRepository;

@RestController
@RequestMapping("reuniaoparticipantes/v1/")
public class ReuniaoParticipantesController {
	
	@Autowired
	ReuniaoParticipantesRepository reuniaoParticipantesRepository;

	
	@RequestMapping(value="reuniaoparticipantes", method=RequestMethod.GET)
	public List<ReuniaoParticipantes> list(){
		//return ParticipanteStub.list();
		return reuniaoParticipantesRepository.findAll();
	}

	@RequestMapping(value = "reuniaoparticipantes", method = RequestMethod.POST)
	public ReuniaoParticipantes create(@RequestBody ReuniaoParticipantes reuniaoParticipante){
		//return ParticipanteStub.create(participante);
		return reuniaoParticipantesRepository.save(reuniaoParticipante);
	}

	@RequestMapping(value = "reuniaoparticipantes/{id}", method = RequestMethod.GET)
	public ReuniaoParticipantes get(@PathVariable Long id){
		//return ParticipanteStub.get(id);
		return reuniaoParticipantesRepository.findOne(id);
	}

	@RequestMapping(value = "reuniaoparticipantes/{id}", method = RequestMethod.PUT)
	public ReuniaoParticipantes update(@PathVariable Long id, @RequestBody ReuniaoParticipantes reuniaoParticipante){
		//return ParticipanteStub.update(id, participante);
		return reuniaoParticipantesRepository.save(reuniaoParticipante);
	}

	@RequestMapping(value = "reuniaoparticipantes/{id}", method = RequestMethod.DELETE)
	public ReuniaoParticipantes delete(@PathVariable Long id){
		//return ParticipanteStub.delete(id);
		reuniaoParticipantesRepository.delete(id);
		return null;
	}
	
	/***************************
	** Relacionados à Reunião **
	****************************/
	
	@RequestMapping(value="reunioes/{id}", method=RequestMethod.GET)
	public List<ReuniaoParticipantes> listReuniao(@PathVariable Long id){
		//return ParticipanteStub.list();
		return reuniaoParticipantesRepository.findAllReunioes(id);
	}
	
		
	/*******************************
	** Relacionados à Participante *
	********************************/
		
	@RequestMapping(value="participantes/{id}", method=RequestMethod.GET)
	public List<ReuniaoParticipantes> listParticipantes(@PathVariable Long id){
		//return ParticipanteStub.list();
		return reuniaoParticipantesRepository.findAllParticipantes(id);
	}
}
