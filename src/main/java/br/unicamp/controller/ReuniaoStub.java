package br.unicamp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unicamp.model.Reuniao;

public class ReuniaoStub {

	private static Map<Long, Reuniao> reunioes = new HashMap<Long, Reuniao>();
	private static Long idIndex = 1L;

	static {
		Reuniao a = new Reuniao();
		reunioes.put(1L, a);
	}

	public static List<Reuniao> list(){
		return new ArrayList<Reuniao>(reunioes.values());
	}

	public static Reuniao create(Reuniao reuniao) {
		idIndex += 1L;
		reuniao.setId(idIndex);
		reunioes.put(idIndex, reuniao);
		return reuniao;
	}

	public static Reuniao get(Long id){
		return reunioes.get(id);
	}

	public static Reuniao update(Long id, Reuniao reuniao) {
		reunioes.put(id, reuniao);
		return reuniao;
	}

	public static Reuniao delete(Long id) {
		return reunioes.remove(id);
	}

}
