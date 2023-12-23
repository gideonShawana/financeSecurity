package com.example.finacemgmt.group.repository;

import com.example.finacemgmt.group.model.Security;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends ReactiveMongoRepository<Security, String> {
}
