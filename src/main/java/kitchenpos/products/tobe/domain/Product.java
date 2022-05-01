package kitchenpos.products.tobe.domain;

import java.util.Objects;
import java.util.UUID;
import kitchenpos.common.domain.DisplayedName;
import kitchenpos.common.domain.Money;
import kitchenpos.products.tobe.domain.event.ProductPriceChangedPriceEvent;
import org.springframework.data.domain.AbstractAggregateRoot;


// AbstractAggregateRoot로 이벤트 발생시 spring data repository의 save() 메서드를 명시적으로 사용해야함
public final class Product extends AbstractAggregateRoot<Product> {

    private final ProductId id;
    private final DisplayedName name;
    private Money price;

    public Product(ProductId id, DisplayedName name, Money price) {
        validPrice(price);
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(UUID id, DisplayedName name, long price) {
        this(new ProductId(id), name, new Money(price));
    }

    private void validPrice(Money price) {
        if (price.isLessThan(Money.ZERO)) {
            throw new IllegalArgumentException(
                String.format("가격은 0보다 작을 수 없습니다. price: %s", price)
            );
        }
    }

    public void changePrice(Money price) {
        validPrice(price);
        this.price = price;
        registerEvent(new ProductPriceChangedPriceEvent(this));
    }

    public ProductId getId() {
        return id;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", name=" + name +
            ", price=" + price +
            '}';
    }
}
