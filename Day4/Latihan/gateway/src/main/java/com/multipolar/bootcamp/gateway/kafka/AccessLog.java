package com.multipolar.bootcamp.gateway.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessLog {
    private String requestMethod;
    private String requestUrl;
    private Integer responseStatusCode;
    private LocalDateTime timeStamps = LocalDateTime.now();
    private String content;
}
