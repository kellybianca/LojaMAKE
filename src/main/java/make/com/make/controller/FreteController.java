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
import make.com.make.model.Frete;
import make.com.make.repositories.FreteRepository;


@RestController
public class FreteController {

	@Autowired
	private FreteRepository freteRepository;
	
	@GetMapping("/frete")
	public Page<Frete> getFrete(Pageable pageable){
		return freteRepository.findAll(pageable);
	}
	
	@GetMapping("/frete/{freteId}")
	public Frete getFrete(@PathVariable Long freteId) {
		return freteRepository.findById(freteId)
				.orElseThrow(() -> new ResourceNotFoundException("Frete not found: "+freteId));
	}
	@PostMapping("/frete")
	public Frete createFrete(@Valid @RequestBody Frete frete) {
		return freteRepository.save(frete);
	}
	
	@PutMapping("/frete/{freteId}")
	public Frete updateFrete(@PathVariable Long freteId,
								@Valid @RequestBody Frete freteRequest) {
		return freteRepository.findById(freteId)
				.map(frete -> {
					frete.setCep(freteRequest.getCep());
					frete.setCliente(freteRequest.getCliente());
					frete.setEndereco(freteRequest.getEndereco());
					frete.setValorTotal(freteRequest.getValorTotal());
					return freteRepository.save(frete);
				}).orElseThrow(() -> new ResourceNotFoundException("Frete not found: "+freteId));
		
	}
	
	@DeleteMapping("/frete/{freteId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long freteId){
		return freteRepository.findById(freteId)
				.map(frete -> {
					freteRepository.delete(frete);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Frete not found: "+freteId));
		
	}
	
}
