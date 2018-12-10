	package make.com.make.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String produto;
	
	@Column
	private String quantidade;
	
	@Column 
	private String validade;
	
	@Column
	private Double valor;
	
	@ManyToMany
	private List<Categoria> categoria = new ArrayList<>();

	
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public void addCategoria(@Valid Categoria categoria) {
		this.categoria.add(categoria);
	}
	
	
	

}
