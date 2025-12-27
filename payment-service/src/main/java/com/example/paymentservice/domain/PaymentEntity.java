package com.example.paymentservice.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.Instant;

@Document(collection = "payments")
@Data
public class PaymentEntity {
    @Id
    private String id;
    private String orderId;
    private String userId;
    private PaymentStatus status;
    private Instant timestamp;
    private BigDecimal paymentAmount;


}
