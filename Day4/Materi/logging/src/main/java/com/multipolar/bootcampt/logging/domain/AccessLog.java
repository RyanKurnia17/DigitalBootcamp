package com.multipolar.bootcampt.logging.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document
public class AccessLog {
    @Id
    private String id;
    private String method;
    private String status;
    private String message;
}
