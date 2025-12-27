
package com.example.paymentservice.kafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventsProducer {
    private final KafkaTemplate<String, String> kafka;
    public PaymentEventsProducer(KafkaTemplate<String, String> kafka){ this.kafka = kafka; }
    public void sendCreatePayment(String payload){ kafka.send("CREATE_PAYMENT", payload); }
}
