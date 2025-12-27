package com.example.paymentservice.mapper;

import com.example.paymentservice.domain.PaymentEntity;
import com.example.paymentservice.dto.CreatePaymentRequest;
import com.example.paymentservice.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {


    PaymentEntity toEntity(CreatePaymentRequest req);


    PaymentDto toDto(PaymentEntity entity);
}
