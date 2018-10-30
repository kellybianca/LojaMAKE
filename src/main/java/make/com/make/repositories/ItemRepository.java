package make.com.make.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import make.com.make.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
