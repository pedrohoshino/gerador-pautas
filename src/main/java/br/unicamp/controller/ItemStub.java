package br.unicamp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unicamp.model.Item;

public class ItemStub {

	private static Map<Long, Item> itens = new HashMap<Long, Item>();
	private static Long idIndex = 3L;

	static {
		Item a = new Item(1L, "Teste", "Teste", "Pendente");
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
