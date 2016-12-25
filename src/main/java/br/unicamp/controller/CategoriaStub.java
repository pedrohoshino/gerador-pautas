package br.unicamp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unicamp.model.Categoria;

public class CategoriaStub {

	private static Map<Long, Categoria> categorias = new HashMap<Long, Categoria>();
	private static Long idIndex = 6L;

	static {
		Categoria a = new Categoria(1L, "ATA DE REUNIÃO", "");
		categorias.put(1L, a);
		Categoria b = new Categoria(2L, "EXPEDIENTE:", "");
		categorias.put(2L, b);
		Categoria c = new Categoria(3L, "PARA CIÊNCIA:", "");
		categorias.put(3L, c);
		Categoria d = new Categoria(4L, "PARA APROVAÇÃO:", "");
		categorias.put(4L, d);
		Categoria e = new Categoria(5L, "HOMOLOGAÇÃO:", "");
		categorias.put(5L, e);
		// Categoria f = new Categoria(6L, "Convênios, Contratos e termos aditivos", "");
		// categorias.put(6L, f);
		// Categoria g = new Categoria(7L, "Graduação |Catálogo; Credenciamento; Revalidação|", "");
		// categorias.put(7L, g);
		// Categoria h = new Categoria(8L, "Pós Graduação |Catálogo; PPPD; Credenciamento; Revalidação|", "");
		// categorias.put(8L, h);
		// Categoria i = new Categoria(9L, "Outros", "");
		// categorias.put(9L, i);
		// Categoria j = new Categoria(10L, "Vida docente |Relatórios de atividade; Afastamentos; Perfis; Atividade Silmultânea|", "");
		// categorias.put(10L, j);
	}

	public static List<Categoria> list(){
		return new ArrayList<Categoria>(categorias.values());
	}

	public static Categoria create(Categoria categoria) {
		idIndex += 1L;
		categoria.setId(idIndex);
		categorias.put(idIndex, categoria);
		return categoria;
	}

	public static Categoria get(Long id){
		return categorias.get(id);
	}

	public static Categoria update(Long id, Categoria categoria) {
		categorias.put(id, categoria);
		return categoria;
	}

	public static Categoria delete(Long id) {
		return categorias.remove(id);
	}

}
