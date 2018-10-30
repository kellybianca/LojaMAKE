package make.com.make.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import make.com.make.model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

}
