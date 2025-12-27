package com.example.paymentservice.web;

import com.example.paymentservice.dto.CreatePaymentRequest;
import com.example.paymentservice.dto.PaymentDto;
import com.example.paymentservice.dto.PaymentFilterRequest;
import com.example.paymentservice.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }


    @PostMapping
    public PaymentDto create(@Valid @RequestBody CreatePaymentRequest req) {
        return service.create(req);
    }


    @GetMapping("/by-order/{orderId}")
    public List<PaymentDto> byOrder(@PathVariable String orderId) {
        return service.byOrderId(orderId);
    }


    @GetMapping("/by-user/{userId}")
    public List<PaymentDto> byUser(@PathVariable String userId) {
        return service.byUserId(userId);
    }


    @PostMapping("/by-statuses")
    public List<PaymentDto> byStatuses(@RequestBody PaymentFilterRequest filter) {
        return service.byStatuses(filter.getStatuses());
    }


    @GetMapping("/total")
    public BigDecimal total(@RequestParam String from, @RequestParam String to) {
        return service.totalForPeriod(java.time.Instant.parse(from), java.time.Instant.parse(to));
    }
}
