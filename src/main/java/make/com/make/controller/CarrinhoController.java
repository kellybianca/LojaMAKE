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
import make.com.make.model.Carrinho;
import make.com.make.repositories.CarrinhoRepository;

@RestController
public class CarrinhoController {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@GetMapping("/carrinho")
	public Page<Carrinho> getCarrinho(Pageable pageable){
		return carrinhoRepository.findAll(pageable);
	}
	
	@PostMapping("/carrinho")//adicionar um novo elemento
	public Carrinho createCarrinho(@Valid @RequestBody Carrinho carrinho) {
		return carrinhoRepository.save(carrinho);
	}
	
	@PutMapping("/carrinho/{carrinhoId}")
	public Carrinho updateCarrinho(@PathVariable Long carrinhoId,
										@Valid @RequestBody Carrinho carrinhoRequest) {
		return carrinhoRepository.findById(carrinhoId)
				.map(carrinho -> {
					carrinho.setCliente(carrinhoRequest.getCliente());
					carrinho.setData(carrinhoRequest.getData());
					carrinho.setItens(carrinhoRequest.getItens());
					carrinho.setTipoPagamento(carrinhoRequest.getTipoPagamento());
					carrinho.setValorTotal(carrinhoRequest.getValorTotal());
					return carrinhoRepository.save(carrinho);
				}).orElseThrow(() -> new ResourceNotFoundException("Carrinho not found: "+carrinhoId));
				
	}
	@DeleteMapping("/carrinho/{carrinhoId}")
	public ResponseEntity<?> deleteQuestion (@PathVariable Long carrinhoId){
		return carrinhoRepository.findById(carrinhoId)
				.map(carrinho -> {
			carrinhoRepository.delete(carrinho);
			return ResponseEntity.ok ().build();
		}) .orElseThrow(()-> new ResourceNotFoundException("carrinho not found" + carrinhoId));
	}
	
	
	
}
