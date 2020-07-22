package kz.iitu.cs.demo.Service;
import kz.iitu.cs.demo.Model.Item;
import kz.iitu.cs.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemRepository repo;

    public List<Item> listAll() { return repo.findAll();
    }

    public void save(Item Item) {
        repo.save(Item);
    }

    public Item get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

}
