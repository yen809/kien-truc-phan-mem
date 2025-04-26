package com.example.authservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ServiceAPI {
    @Autowired
    private  RestTemplate restTemplate;

    public <T> T call(String urlService, HttpMethod method, Object requestBody, Class<T> responseType, String token) {
        System.out.println("call to " + urlService + " " + method + " " + requestBody);
        try {
            // Create headers and add JWT token
            HttpHeaders headers = new HttpHeaders();
            if (token != null && !token.isEmpty()) {
                headers.set("Authorization", "Bearer " + token);
            }

            // Create HttpEntity with headers and body
            HttpEntity<?> httpEntity = requestBody != null ?
                    new HttpEntity<>(requestBody, headers) :
                    new HttpEntity<>(headers);
            System.out.println("httpEntity: " + httpEntity);
            ResponseEntity<T> response = restTemplate.exchange(urlService, method, httpEntity, responseType);
            return response.getBody();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to call service: " + urlService + ", error: " + e.getMessage());
        }
    }
}
