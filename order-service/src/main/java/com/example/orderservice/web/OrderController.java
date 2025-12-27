// web/OrderController.java
package com.example.orderservice.web;
import com.example.orderservice.kafka.OrderEventsProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderEventsProducer producer;
    public OrderController(OrderEventsProducer producer){ this.producer = producer; }

    @PostMapping
    public String createOrder(@RequestBody String orderPayload){
        producer.sendCreateOrder(orderPayload);
        return "ORDER_EVENT_SENT";
    }
}
