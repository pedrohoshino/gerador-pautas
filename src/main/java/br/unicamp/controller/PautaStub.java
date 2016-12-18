package br.unicamp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unicamp.model.Pauta;

public class PautaStub {

	private static Map<Long, Pauta> pautas = new HashMap<Long, Pauta>();
	private static Long idIndex = 1L;

	static {
		Pauta a = new Pauta(1L, "Demo", "Demostração de template de Reunião", "<blockquote><h5><b>DE ORDEM, CONVOCAMOS OS MEMBROS DA CONGREGAÇÃO DO INSTITUTO DE COMPUTAÇÃO PARA A <u><strike>ø</strike></u></b><b> REUNIÃO </b><u><b><strike>ORDINÁRIA</strike></b></u><b> DA CONGREGAÇÃO, A REALIZAR-SE DIA </b><u><strike><i><b>00/00/000</b></i></strike></u><b>, ÀS <i><u><strike>00H00</strike></u></i>, NA SALA <i><u><strike>00</strike></u></i> DO INSTITUTO DE COMPUTAÇÃO.</b></h5><div><b><br/></b></div><div><b>ATA DE REUNIÃO<br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b>EXPEDIENTE:<br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b>PARA CIÊNCIA:<br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b>ORDEM DO DIA<br/></b></div><div><b>PARA APROVAÇÃO:<br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b>HOMOLOGAÇÃO:<br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b><br/></b></div><h4><b><br/></b></h4></blockquote>");
		pautas.put(1L, a);
	}

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
