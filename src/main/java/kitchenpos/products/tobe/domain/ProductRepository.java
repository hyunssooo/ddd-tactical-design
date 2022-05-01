package kitchenpos.products.tobe.domain;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {

    Product save(Product product);

    Product findById(ProductId id);

    List<Product> findAll();

    List<Product> findAllByIdIn(List<ProductId> ids);
}
