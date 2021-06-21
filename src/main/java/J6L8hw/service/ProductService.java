package J6L8hw.service;

import org.springframework.data.domain.Page;
import J6L8hw.model.Product;

public interface ProductService {

    Page<Product> findAll(int pageNumber);

    Product findById(int id);

    void save(Product product);

    void delete(int id);
}
