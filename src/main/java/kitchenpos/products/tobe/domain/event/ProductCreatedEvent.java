package kitchenpos.products.tobe.domain.event;

import kitchenpos.products.tobe.domain.Product;
import kitchenpos.products.tobe.domain.ProductId;

public class ProductCreatedEvent {
    private ProductId id;

    public ProductCreatedEvent(Product product) {
        this.id = product.getId();
    }

    public ProductId getId() {
        return id;
    }
}
