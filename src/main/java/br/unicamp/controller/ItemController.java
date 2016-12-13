package br.unicamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.model.Item;
import br.unicamp.repository.ItemRepository;

@RestController
@RequestMapping("item/v1/")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@RequestMapping(value="itens", method=RequestMethod.GET)
	public List<Item> list(){
		return ItemStub.list();
	}
	
	@RequestMapping(value = "itens", method = RequestMethod.POST)
	public Item create(@RequestBody Item item){
		return ItemStub.create(item);
	}
	
	@RequestMapping(value = "itens/{id}", method = RequestMethod.GET)
	public Item get(@PathVariable Long id){
		return ItemStub.get(id);
	}

	@RequestMapping(value = "itens/{id}", method = RequestMethod.PUT)
	public Item update(@PathVariable Long id, @RequestBody Item item){
		return ItemStub.update(id, item);
	}

	@RequestMapping(value = "itens/{id}", method = RequestMethod.DELETE)
	public Item delete(@PathVariable Long id){
		return ItemStub.delete(id);
	}
	

}
