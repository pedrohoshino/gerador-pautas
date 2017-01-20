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
		Ata a = new Ata(1L, "Teste", "Exemplo de uma ata", "03/08/2016", "<blockquote><blockquote><b style='color: inherit;'>ATA DA TERCEIRA REUNIÃO EXTRAORDINÁRIA DA CONGREGAÇÃO DO INSTITUTO DECOMPUTAÇÃO, REALIZADA EM 03/08/2016.</b></blockquote><blockquote><h5>Ao terceiro dia do mês de agosto de dois mil e dezesseis, às dez horas, na Sala 85 do Instituto de Computação, realizou-se a <b>3ª Reunião Extraordinária da Congregação</b>, sob a Presidência do Prof.Dr. Ricardo da Silva Torres, contando com o comparecimento dos seguintes Membros, Profs. Drs.:Cecília Mary Fischer Rubira, Claudia Maria Bauzer Medeiros, Eduardo Candido Xavier, Flávio Keidi Miyazawa, Guilherme Telles Pimentel, Luiz Eduardo Buzato, Mario Lúcio Côrtes, Orlando Lee, PauloLício de Geus, Rodolfo de Jardim Azevedo, Siome Klein Goldenstein e Zanoni Dias. <b>Representantes Discentes: </b>Daniel Helú Prestes de Oliveira, Jacqueline Midlej do Espirito Santo, Henrique Noronha Facioli e Marcelo Invert Palma Salas. <b>Representante Funcionários: </b>Wilson Bagni Junior. <b>Convidado(s):</b> Professor Ricardo Dahab. O <b>Sr. Presidente</b> dá início à 3ª Sessão Extraordinária daCongregação de 2016 e coloca para apreciação a Ata da 3ª Reunião Ordinária da Congregação,realizada no dia 06/07/2016.<b> APROVADA COM 02 ABSTENÇÕES</b>. A seguir, o<b> Sr. Presidente </b>inicia o<b> EXPEDIENTE: 01 - Informes Gerais: </b>A<b> Professora Claudia</b> informa:<b> a) </b>que o CONSU foi iniciado às 09h10min e terminou as às 19h30min sendo o Expediente movido para a próxima semana. Durante o curso da reunião houve uma interrupção violenta de grevistas, danificando a porta de acesso à sala do CONSU, o que gerou a manifestação de docentes que protestavam em virtudedos acontecimentos. Após ofensas e ameaças à Reitoria e aos presentes, os manifestantes fizeram muito barulho. Informa ainda que nada foi falado sobre o calendário. O<b> Professor Rodolfo </b>tece outros comentários e informa que: b) um grupo de docentes tentou falar com o Reitor, mas não foi atendido. c) A moção da Congregação do IC será lida na próxima semana.");
		atas.put(1L, a);
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
