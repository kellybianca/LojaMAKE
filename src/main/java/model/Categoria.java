package model;
import javax.persistence.*;
@Entity
public class Categoria {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToMany(mappedBy = "categoria")
	private Item item;
	@Column
	private String nome;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
