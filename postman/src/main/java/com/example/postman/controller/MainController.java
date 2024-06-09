package com.example.postman.controller;

import com.fasterxml.jackson.databind.JsonSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Controller is up and running!");
    }


    @PostMapping(value="/inquiry", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InquiryReponse> handleInquiry(@RequestBody InquiryRequest inquiryRequest) {
        // Logic to handle inquiry
        InquiryReponse inquiryReponse = new InquiryReponse();
        inquiryReponse.setUserId(inquiryRequest.getEmail());
        return ResponseEntity.ok(inquiryReponse);
    }

    @PostMapping("/payment")
    public ResponseEntity<String> handlePayment(@RequestBody PaymentRequest paymentRequest) {
        // Logic to process payment
        return ResponseEntity.ok("Payment processed: " + paymentRequest);
    }

    // DTO for InquiryRequest
    @Getter
    @Setter
    static class InquiryRequest {
        private String name;
        private String email;
        private String subject;
        private String message;
        private String inquiryDate;

        // Getters and Setters
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class  InquiryReponse{
        private String userId;
    }

    // DTO for PaymentRequest
    @Getter
    @Setter
    static class PaymentRequest {
        private String userId;
        private Double amount;
        private String currency;
        private String paymentMethod;
        private String paymentDate;

        // Getters and Setters
    }
}
