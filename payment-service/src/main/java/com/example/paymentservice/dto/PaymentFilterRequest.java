package com.example.paymentservice.dto;

import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
public class PaymentFilterRequest {
    private String orderId;
    private String userId;
    private List<String> statuses;
    private Instant from;
    private Instant to;

}