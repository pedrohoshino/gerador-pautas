package br.unicamp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unicamp.model.Pauta;

public class PautaStub {

	private static Map<Long, Pauta> pautas = new HashMap<Long, Pauta>();
	private static Long idIndex = 1L;

	public static List<Pauta> list(){
		return new ArrayList<Pauta>(pautas.values());
	}

	public static Pauta create(Pauta pauta) {
		idIndex += 1L;
		pauta.setId(idIndex);
		pautas.put(idIndex, pauta);
		return pauta;
	}

	public static Pauta get(Long id){
		return pautas.get(id);
	}

	public static Pauta update(Long id, Pauta item) {
		pautas.put(id, item);
		return item;
	}

	public static Pauta delete(Long id) {
		return pautas.remove(id);
	}

}
