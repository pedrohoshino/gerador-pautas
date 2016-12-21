package br.unicamp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unicamp.model.Deliberacao;

public class DeliberacaoStub {
	
	private static Map<Long, Deliberacao> deliberacoes = new HashMap<Long, Deliberacao>();
	private static Long idIndex = 1L;
	
	public static List<Deliberacao> list(){
		return new ArrayList<Deliberacao>(deliberacoes.values());
	}

	public static Deliberacao create(Deliberacao deliberacao) {
		idIndex += 1L;
		deliberacao.setId(idIndex);
		deliberacoes.put(idIndex, deliberacao);
		return deliberacao;
	}

	public static Deliberacao get(Long id){
		return deliberacoes.get(id);
	}

	public static Deliberacao update(Long id, Deliberacao deliberacao) {
		deliberacoes.put(id, deliberacao);
		return deliberacao;
	}

	public static Deliberacao delete(Long id) {
		return deliberacoes.remove(id);
	}

}
