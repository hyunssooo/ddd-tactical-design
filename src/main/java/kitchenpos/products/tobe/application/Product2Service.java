package kitchenpos.products.tobe.application;

import java.util.UUID;
import kitchenpos.common.domain.DisplayedName;
import kitchenpos.products.tobe.domain.Product;
import kitchenpos.products.tobe.domain.event.ProductCreatedEvent;
import kitchenpos.products.tobe.domain.event.ProductPriceChangedPriceEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class Product2Service {

    private final ApplicationEventPublisher publisher;


    public Product2Service(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Transactional
    public void create(String name, long price) {
        System.out.println(Thread.currentThread());
        final Product product = new Product(
            UUID.randomUUID(),
            new DisplayedName(name, text -> false),
            price
        );
        publisher.publishEvent(new ProductCreatedEvent(product));
        publisher.publishEvent(new ProductPriceChangedPriceEvent(product));
    }

}
