package com.multipolar.bootcamp.logging.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document
public class AccountLog {
    @Id
    private String id;
    private String httpMethod;
    private String requestUrl;
    private Integer responseStatusCode;
    private String content;
    private String clientIP;
    private String userAgent;
    private LocalDateTime timeStamp;
}
