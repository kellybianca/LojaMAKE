package make.com.make.model;
import javax.persistence.*;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	
	@Column (nullable = false)
	private String nome;
	@Column (nullable = false, unique=true)
	private  String cpf;

	@OneToOne(
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private Carrinho carrinho;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	  
	
}
