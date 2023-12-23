package com.example.finacemgmt.group.service;

import com.example.finacemgmt.group.model.Portfolio;
import com.example.finacemgmt.group.repository.PortfolioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    public Flux<Portfolio> getAll(){
        return portfolioRepository.findAll();
    }

    public Mono<Portfolio> save(final Portfolio  portfolio){
        return portfolioRepository.save(portfolio);
    }

    public Mono<Portfolio> getById(final String id){
        return portfolioRepository.findById(id);
    }

    public Mono<Portfolio> update(final String id, Portfolio portfolio){
        return portfolioRepository.findById(id).flatMap(existingPortfolio -> {
            existingPortfolio.setCreationDate(portfolio.getCreationDate());

            return portfolioRepository.save(existingPortfolio);
        });
    }

    public Mono<?> delete(final String id){
        return getById(id).switchIfEmpty(Mono.empty())
                .flatMap(portfolioToBeDeleted -> {
                    return portfolioRepository.delete(portfolioToBeDeleted).then(Mono.just(portfolioToBeDeleted));
                })
                .switchIfEmpty(Mono.empty());
    }
}
