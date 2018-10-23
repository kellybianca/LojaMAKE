package make.com.make.model;
import javax.persistence.*;

@Entity
public class Frete {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Cliente cliente;
	@Column
	private Long cep;
	@Column
	private Double valorTotal;
	@Column
	private String endereco;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Long getCep() {
		return cep;
	}
	public void setCep(Long cep) {
		this.cep = cep;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
}
