package make.com.make.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import make.com.make.exception.ResourceNotFoundException;
import make.com.make.model.Categoria;
import make.com.make.model.Item;
import make.com.make.repositories.ItemRepository;

@RestController
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/item")
	public Page<Item> getItem(Pageable pageable){
		return itemRepository.findAll(pageable);
	}
	
	@GetMapping("/item/{itemId}")
	public Item getItem(@PathVariable Long itemId) {
		return itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("item not found: "+itemId));
	}
	
	@PostMapping("/item")
	public Item createItem(@Valid @RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	@PostMapping ("item/{itemId}/addcategoria")
	public Item addItem (@PathVariable Long itemId,
													@Valid @RequestBody Categoria categoria) {
		return itemRepository.findById(itemId)
				.map(item -> {
					item.addCategoria(categoria);
					return itemRepository.save(item);
		}).orElseThrow(() -> new ResourceNotFoundException("Not found: "+itemId));
		
	}
	
	@PutMapping("/item/{itemId}")
	public Item updateItem(@PathVariable Long itemId,
								@Valid @RequestBody Item itemRequest) {
		return itemRepository.findById(itemId)
				.map(item -> {
					item.setProduto(itemRequest.getProduto());
					item.setQuantidade(itemRequest.getQuantidade());
					item.setValor(itemRequest.getValor());
					return itemRepository.save(item);
				}).orElseThrow(() -> new ResourceNotFoundException("item not found: "+itemId));
	}
	
	
	@DeleteMapping("/item/{itemId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long itemId){
		return itemRepository.findById(itemId)
				.map(item -> {
					itemRepository.delete(item);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Item not found: "+itemId));
	}
}
