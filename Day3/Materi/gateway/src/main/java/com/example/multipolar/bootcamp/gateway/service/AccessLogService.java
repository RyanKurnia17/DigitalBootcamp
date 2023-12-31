package com.example.multipolar.bootcamp.gateway.service;

import com.example.multipolar.bootcamp.gateway.kafka.AccessLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccessLogService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public AccessLogService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void logAccess(AccessLog accessLog) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String accessLogMessage = objectMapper.writeValueAsString(accessLog);
            kafkaTemplate.send("access-logs", accessLogMessage);
        } catch (KafkaException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
