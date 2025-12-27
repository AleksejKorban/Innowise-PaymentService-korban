
package com.example.paymentservice.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventsConsumer {
    @KafkaListener(topics = "CREATE_ORDER", groupId = "payment-service")
    public void onCreateOrder(String msg) {
        System.out.println("PaymentService consumed CREATE_ORDER: " + msg);
    }
}
