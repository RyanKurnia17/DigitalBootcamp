package com.multipolar.bootcampt.logging.repository;

import com.multipolar.bootcampt.logging.domain.AccessLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccessLogRepository extends MongoRepository<AccessLog, String> {

}
