package kz.iitu.cs.demo.Repository;

import kz.iitu.cs.demo.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
