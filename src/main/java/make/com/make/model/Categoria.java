package make.com.make.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Categoria {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany(mappedBy = "categoria")
	private List<Item> itens = new ArrayList<>();
	
	@Column
	private String nome;
	public Long getId() {
		return id;	
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens.clear();
		this.itens.addAll(itens);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
