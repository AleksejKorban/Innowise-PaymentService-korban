
package com.example.paymentservice.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RandomNumberClient {
    private final RestTemplate rest = new RestTemplate();

    public int getRandom() {

        try {
            Integer value = rest.getForObject("https://www.randomnumberapi.com/api/v1.0/random?min=1&max=100&count=1", Integer[].class)[0];
            return value == null ? 1 : value;
        } catch (Exception e) {
            return (int)(System.currentTimeMillis() % 100);
        }
    }

    public boolean isEven(int n) { return n % 2 == 0; }
}
