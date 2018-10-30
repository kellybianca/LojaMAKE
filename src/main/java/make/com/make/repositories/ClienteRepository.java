package make.com.make.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import make.com.make.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
