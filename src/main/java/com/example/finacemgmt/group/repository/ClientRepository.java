package com.example.finacemgmt.group.repository;

import com.example.finacemgmt.group.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends ReactiveMongoRepository <Client, String> {
}
