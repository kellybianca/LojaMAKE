package make.com.make.model;
import javax.persistence.*;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany(mappedBy = "itens")
	private String produto;
	
	@Column
	private String quantidade;
	
	@Column
	private Double valor;
	
	@ManyToMany
	private Categoria categoria;
	
	
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
	
	

}
