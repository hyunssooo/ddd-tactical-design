package kitchenpos.products.tobe.domain.event;

import kitchenpos.common.domain.Money;
import kitchenpos.products.tobe.domain.Product;
import kitchenpos.products.tobe.domain.ProductId;

public class ProductPriceChangedPriceEvent {
    private ProductId id;
    private Money price;

    public ProductPriceChangedPriceEvent(Product product) {
        this.id = product.getId();
        this.price = product.getPrice();
    }

    public ProductId getId() {
        return id;
    }

    public Money getPrice() {
        return price;
    }
}
