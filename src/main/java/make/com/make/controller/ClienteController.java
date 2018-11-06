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
import make.com.make.model.Cliente;
import make.com.make.repositories.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/cliente")
	public Page<Cliente> getCliente(Pageable pageable){
		return clienteRepository.findAll(pageable);
	}
	
	@GetMapping("/cliente/{clienteId}")
	public Cliente getCliente(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente not found: "+clienteId));
	}
	@PostMapping("/cliente")
	public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/cliente/{clienteId}")
	public Cliente updateCliente(@PathVariable Long clienteId,
						@Valid @RequestBody Cliente clienteRequest) {
		return clienteRepository.findById(clienteId)
				.map(cliente -> {
					cliente.setCpf(clienteRequest.getCpf());
					cliente.setNome(clienteRequest.getNome());
					cliente.setSenha(clienteRequest.getSenha());
					return clienteRepository.save(cliente);
				}).orElseThrow(() -> new ResourceNotFoundException("Cliente not found: "+clienteId));
	}
	
	@DeleteMapping("/cliente/{clienteId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long clienteId){
		return clienteRepository.findById(clienteId)
				.map(cliente -> {
					clienteRepository.delete(cliente);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Cliente not found: "+clienteId));
	}
	
}
