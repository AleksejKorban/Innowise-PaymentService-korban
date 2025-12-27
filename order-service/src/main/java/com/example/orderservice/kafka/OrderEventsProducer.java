
package com.example.orderservice.kafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventsProducer {
    private final KafkaTemplate<String, String> kafka;
    public OrderEventsProducer(KafkaTemplate<String, String> kafka){ this.kafka = kafka; }
    public void sendCreateOrder(String payload){ kafka.send("CREATE_ORDER", payload); }
}
