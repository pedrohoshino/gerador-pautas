package br.unicamp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unicamp.model.Ata;

public class AtaStub {

	private static Map<Long, Ata> atas = new HashMap<Long, Ata>();
	private static Long idIndex = 1L;
	
	
	static {
	}

	public static List<Ata> list(){
		return new ArrayList<Ata>(atas.values());
	}

	public static Ata create(Ata ata) {
		idIndex += 1L;
		ata.setId(idIndex);
		atas.put(idIndex, ata);
		return ata;
	}

	public static Ata get(Long id){
		return atas.get(id);
	}

	public static Ata update(Long id, Ata ata) {
		atas.put(id, ata);
		return ata;
	}

	public static Ata delete(Long id) {
		return atas.remove(id);
	}

}
