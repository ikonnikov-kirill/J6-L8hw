package J6L8hw.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import J6L8hw.model.Product;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    List<Product> findAll(Sort sort);

    Product findById(int id);

    void deleteById(Integer integer);

    Product save(Product product);


}
