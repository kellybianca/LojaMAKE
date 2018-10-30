package make.com.make.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import make.com.make.model.Frete;

@Repository
public interface FreteReposity extends JpaRepository<Frete, Long>{

}
