package com.multipolar.bootcamp.logging.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multipolar.bootcamp.logging.domain.AccountLog;
import com.multipolar.bootcamp.logging.repository.AccessLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final ObjectMapper objectMapper;
    private final AccessLogRepository accessLogRepository;

    @Autowired
    public KafkaConsumerService(ObjectMapper objectMapper, AccessLogRepository accessLogRepository) {
        this.objectMapper = objectMapper;
        this.accessLogRepository = accessLogRepository;
    }

    @KafkaListener(topics = "access-accounts-logs")
    public void receiveMessage(String message) {
        try {
            // Deserialize the JSON message into an AccessLog object
            AccountLog accountLog = objectMapper.readValue(message, AccountLog.class);
            System.out.println("Received message: " + accountLog);
            accessLogRepository.insert(accountLog);
        } catch (Exception e) {
            // Handle any exceptions that may occur during deserialization
            System.err.println("Error processing message: " + e.getMessage());
        }
    }

}
