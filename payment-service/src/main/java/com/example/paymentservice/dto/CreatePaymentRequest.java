package com.example.paymentservice.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class CreatePaymentRequest {
    @NotBlank private String orderId;
    @NotBlank private String userId;
    @NotNull @Positive private BigDecimal paymentAmount;

}