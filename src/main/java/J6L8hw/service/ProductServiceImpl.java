package J6L8hw.service;

import J6L8hw.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import J6L8hw.model.Product;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final int MAX_ITEMS_PER_PAGE = 10;

    @Override
    public Page<Product> findAll(int pageNumber) {
        Pageable page =  PageRequest.of(pageNumber, MAX_ITEMS_PER_PAGE, Sort.by("name"));
        return productRepository.findAll(page);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }


}
