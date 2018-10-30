package make.com.make.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import make.com.make.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
