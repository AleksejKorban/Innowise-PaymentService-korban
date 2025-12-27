package com.example.paymentservice.repo;


import com.example.paymentservice.domain.PaymentEntity;
import com.example.paymentservice.domain.PaymentStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface PaymentRepository extends MongoRepository<PaymentEntity, String> {
    List<PaymentEntity> findByOrderId(String orderId);
    List<PaymentEntity> findByUserId(String userId);
    List<PaymentEntity> findByStatusIn(List<PaymentStatus> statuses);
    List<PaymentEntity> findByTimestampBetween(Instant from, Instant to);
}