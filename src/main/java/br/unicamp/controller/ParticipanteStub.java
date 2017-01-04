package br.unicamp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unicamp.model.Participante;

public class ParticipanteStub {

	private static Map<Long, Participante> participantes = new HashMap<Long, Participante>();
	private static Long idIndex = 6L;
	
	public static List<Participante> list(){
		return new ArrayList<Participante>(participantes.values());
	}

	public static Participante create(Participante participante) {
		idIndex += 1L;
		participante.setId(idIndex);
		participantes.put(idIndex, participante);
		return participante;
	}

	public static Participante get(Long id){
		return participantes.get(id);
	}

	public static Participante update(Long id, Participante participante) {
		participantes.put(id, participante);
		return participante;
	}

	public static Participante delete(Long id) {
		return participantes.remove(id);
	}
}
