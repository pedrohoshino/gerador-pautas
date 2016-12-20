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
		Reuniao a = new Reuniao(1L, "Demo", "Demostração de template de Reunião", "Sala 85", "10/09/2016", "10:00", "<blockquote><h5><b>DE ORDEM, CONVOCAMOS OS MEMBROS DA CONGREGAÇÃO DO INSTITUTO DE COMPUTAÇÃO PARA A <u><strike>ø</strike></u></b><b> REUNIÃO </b><u><b><strike>ORDINÁRIA</strike></b></u><b> DA CONGREGAÇÃO, A REALIZAR-SE DIA </b><u><strike><i><b>00/00/000</b></i></strike></u><b>, ÀS <i><u><strike>00H00</strike></u></i>, NA SALA <i><u><strike>00</strike></u></i> DO INSTITUTO DE COMPUTAÇÃO.</b></h5><div><b><br/></b></div><div><b>ATA DE REUNIÃO<br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b>EXPEDIENTE:<br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b>PARA CIÊNCIA:<br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b>ORDEM DO DIA<br/></b></div><div><b>PARA APROVAÇÃO:<br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b>HOMOLOGAÇÃO:<br/></b></div><div><b><br/></b></div><div><b><br/></b></div><div><b><br/></b></div><h4><b><br/></b></h4></blockquote>");
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

	public static Reuniao update(Long id, Reuniao item) {
		reunioes.put(id, item);
		return item;
	}

	public static Reuniao delete(Long id) {
		return reunioes.remove(id);
	}

}
