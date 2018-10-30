package make.com.make.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import make.com.make.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
