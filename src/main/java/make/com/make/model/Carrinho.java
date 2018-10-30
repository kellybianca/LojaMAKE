package make.com.make.model;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import javax.persistence.*;
@Entity
public class Carrinho {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(mappedBy ="carrinho")
	private Cliente cliente;
	
	@Column
	private LocalDateTime data;
	
	@Column
	private TipoPagamento tipoPagamento;
	
	@ManyToMany
	private List<Item> itens = new ArrayList<>();
	
	@Column
	private Double valorTotal;
	
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
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public List<Item> getItens() {
		
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens.clear();
		this.itens.addAll(itens);
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
