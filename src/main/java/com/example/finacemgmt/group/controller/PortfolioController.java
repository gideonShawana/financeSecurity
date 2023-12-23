package com.example.finacemgmt.group.controller;


import com.example.finacemgmt.group.model.Portfolio;
import com.example.finacemgmt.group.service.PortfolioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/portfolio")
@CrossOrigin("http://localhost:3000/")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

   @GetMapping
    public Flux<Portfolio> getAll(){
        return portfolioService.getAll();
    }

  @PostMapping
    public Mono<Portfolio> save(final Portfolio portfolio){
        return portfolioService.save(portfolio);
    }

    @GetMapping("{id}")
    public Mono<Portfolio>getById(@PathVariable("id") final String id){
       return portfolioService.getById(id);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Portfolio>> update(@PathVariable ("id") final String id, @RequestBody Portfolio portfolio){
       return portfolioService.update(id, portfolio)
               .map(updatedPortfolio -> ResponseEntity.ok().body(updatedPortfolio))
               .defaultIfEmpty(ResponseEntity.notFound().build())
               .onErrorResume(error -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }
    @DeleteMapping("/{id}")
    public Mono<?> delete(@PathVariable final String id){
       return portfolioService.delete(id);
    }
}
