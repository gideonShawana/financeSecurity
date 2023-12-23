package com.example.finacemgmt.group.repository;

import com.example.finacemgmt.group.model.Portfolio;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends ReactiveMongoRepository <Portfolio,String>{
}
