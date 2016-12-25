package br.unicamp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unicamp.model.Item;

public class ItemStub {

	private static Map<Long, Item> itens = new HashMap<Long, Item>();
	private static Long idIndex = 2L;

	static {
		Item a = new Item(1L, "Item Teste", "Relatório Periódico de Atividades do Prof. Fábio Usberti MS-3.1 em RDIDP referente ao período de junho/2013 a maio/2016. Parecer favorável CAA 043/2016. Deliberação favorável DTC 016/2016.", "Pendente");
		itens.put(1L, a);
	}

	public static List<Item> list(){
		return new ArrayList<Item>(itens.values());
	}

	public static Item create(Item item) {
		idIndex += 1L;
		item.setId(idIndex);
		itens.put(idIndex, item);
		return item;
	}

	public static Item get(Long id) {
		return itens.get(id);
	}

	public static Item update(Long id, Item item) {
		itens.put(id, item);
		return item;
	}

	public static Item delete(Long id) {
		return itens.remove(id);
	}

}
