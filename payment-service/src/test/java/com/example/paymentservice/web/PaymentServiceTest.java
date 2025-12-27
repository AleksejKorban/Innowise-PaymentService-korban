package com.example.paymentservice.web;

import com.example.paymentservice.dto.CreatePaymentRequest;
import com.example.paymentservice.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PaymentControllerTest {

    @Test
    void createPaymentReturns200() throws Exception {

        PaymentService service = Mockito.mock(PaymentService.class);
        PaymentController controller = new PaymentController(service);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


        CreatePaymentRequest req = new CreatePaymentRequest();
        req.setOrderId("ORD1");
        req.setUserId("USR1");
        req.setPaymentAmount(BigDecimal.valueOf(100));

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/api/payments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(req)))
                .andExpect(status().isOk());
    }
}
