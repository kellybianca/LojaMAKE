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
import make.com.make.repositories.CategoriaRepository;

@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/categoria")
	public Page<Categoria> getCategoria(Pageable pageable){
			return categoriaRepository.findAll(pageable);
	}
	
	@GetMapping("/categoria/{categoriaId}")
	public Categoria getCategoria(@PathVariable Long categoriaId) {
		return categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new ResourceNotFoundException("Categoria not found: " +categoriaId));
	}
	
	@PostMapping("/categoria")
	public Categoria createCategoria(@Valid @RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@PutMapping("/categoria/{categoriaId}")
	public Categoria updateCategoria(@PathVariable Long categoriaId,
							@Valid @RequestBody Categoria categoriaRequest){
		return categoriaRepository.findById(categoriaId)
				.map(categoria -> {
					categoria.setItens(categoriaRequest.getItens());
					categoria.setNome(categoriaRequest.getNome());
					return categoriaRepository.save(categoria);
				}).orElseThrow(() -> new ResourceNotFoundException("Categoria not found: " +categoriaId));
	}
	
	@DeleteMapping("/categoria/{categoriaId}")
	public ResponseEntity<?> deleteQuestion (@PathVariable Long categoriaId){
		return categoriaRepository.findById(categoriaId)
				.map(categoria -> {
					categoriaRepository.delete(categoria);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Categoria not found: " +categoriaId));
	}
}
