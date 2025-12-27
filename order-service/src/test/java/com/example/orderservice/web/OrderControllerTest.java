package com.example.orderservice.web;

import com.example.orderservice.kafka.OrderEventsProducer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderControllerTest {

    @Test
    void createOrderReturns200() throws Exception {

        OrderEventsProducer producer = Mockito.mock(OrderEventsProducer.class);
        OrderController controller = new OrderController(producer);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderId\":\"ORD1\"}"))
                .andExpect(status().isOk());
    }
}
