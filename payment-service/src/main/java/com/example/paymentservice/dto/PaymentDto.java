package com.example.paymentservice.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PaymentDto {
    private String id;
    private String orderId;
    private String userId;
    private String status;
    private Instant timestamp;
    private BigDecimal paymentAmount;
}
