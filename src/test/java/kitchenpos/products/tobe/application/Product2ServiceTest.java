package kitchenpos.products.tobe.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

@RecordApplicationEvents //boot 2.4 이상
@SpringBootTest
class Product2ServiceTest {

    @Autowired
    private Product2Service service;

    @Autowired //boot 2.4 이상
    private ApplicationEvents events;

    @Test
    void contextLoad() {
        assertThat(service).isNotNull();
    }

    @Test
    void create() {
        service.create("name", 1000);

    }
}
