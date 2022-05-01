package kitchenpos.products.tobe.infra;

import kitchenpos.products.tobe.domain.event.ProductCreatedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class EmailSender {

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void send(ProductCreatedEvent event) {
        System.out.println(Thread.currentThread());
        System.out.println("email send id:" + event.getId());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void sendFail(ProductCreatedEvent event) {
        System.out.println(Thread.currentThread());
        System.out.println("email send fail id:" + event.getId());
    }

}
