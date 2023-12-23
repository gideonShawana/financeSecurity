package com.example.finacemgmt.group.repository;

import com.example.finacemgmt.group.model.Advisor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvisorRepository extends ReactiveMongoRepository<Advisor, String> {
}
