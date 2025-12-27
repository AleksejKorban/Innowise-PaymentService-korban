// service/PaymentService.java
package com.example.paymentservice.service;

import com.example.paymentservice.domain.PaymentEntity;
import com.example.paymentservice.domain.PaymentStatus;
import com.example.paymentservice.dto.CreatePaymentRequest;
import com.example.paymentservice.dto.PaymentDto;
import com.example.paymentservice.mapper.PaymentMapper;
import com.example.paymentservice.repo.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private final PaymentRepository repo;
    private final PaymentMapper mapper;
    private final RandomNumberClient rng;

    public PaymentService(PaymentRepository repo, PaymentMapper mapper, RandomNumberClient rng) {
        this.repo = repo; this.mapper = mapper; this.rng = rng;
    }

    @Transactional
    public PaymentDto create(CreatePaymentRequest req) {
        PaymentEntity entity = mapper.toEntity(req);
        int n = rng.getRandom();
        entity.setStatus(rng.isEven(n) ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);
        entity = repo.save(entity);
        return mapper.toDto(entity);
    }

    public List<PaymentDto> byOrderId(String orderId) {
        return repo.findByOrderId(orderId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<PaymentDto> byUserId(String userId) {
        return repo.findByUserId(userId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<PaymentDto> byStatuses(List<String> statuses) {
        List<PaymentStatus> st = statuses.stream().map(PaymentStatus::valueOf).collect(Collectors.toList());
        return repo.findByStatusIn(st).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public BigDecimal totalForPeriod(Instant from, Instant to) {
        return repo.findByTimestampBetween(from, to).stream()
                .map(PaymentEntity::getPaymentAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
