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
@Document(collection = "productsAccessLog")
public class AccessLog {
    @Id
    private String id;
    private String requestMethod;
    private String requestUrl;
    private Integer responseStatusCode;
    private LocalDateTime timeStamps = LocalDateTime.now();
    private String content;
}
