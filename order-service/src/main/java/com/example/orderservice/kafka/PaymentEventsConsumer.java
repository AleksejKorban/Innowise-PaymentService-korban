
package com.example.orderservice.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventsConsumer {
    @KafkaListener(topics = "CREATE_PAYMENT", groupId = "order-service")
    public void onCreatePayment(String msg) {

        System.out.println("OrderService consumed CREATE_PAYMENT: " + msg);
    }
}
