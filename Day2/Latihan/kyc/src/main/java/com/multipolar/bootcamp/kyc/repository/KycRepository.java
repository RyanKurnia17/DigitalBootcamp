package com.multipolar.bootcamp.kyc.repository;

import com.multipolar.bootcamp.kyc.domain.Kyc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KycRepository extends MongoRepository<Kyc, String> {
}
