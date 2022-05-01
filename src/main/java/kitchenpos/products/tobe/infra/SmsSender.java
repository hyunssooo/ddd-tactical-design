package kitchenpos.products.tobe.infra;

import kitchenpos.products.tobe.domain.event.ProductCreatedEvent;
import kitchenpos.products.tobe.domain.event.ProductPriceChangedPriceEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class SmsSender {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void send(ProductCreatedEvent event) {
        System.out.println(Thread.currentThread());
        System.out.println("sms send id:" + event.getId());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void sendFail(ProductCreatedEvent event) {
        System.out.println(Thread.currentThread());
        System.out.println("email send fail id:" + event.getId());
    }

    @EventListener(condition = "#event.price.value >= 1000") //getter 기반
    public void priceChangedPrice(ProductPriceChangedPriceEvent event) {
        System.out.println(Thread.currentThread());
        System.out.println(
            String.format(
                "sms send id: %s, price: %s",
                event.getId(),
                event.getPrice()
            )
        );
    }

}
