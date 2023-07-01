package br.com.tech4me.tech4fifa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4fifa.model.Clubs;

public interface ClubsRepository extends MongoRepository<Clubs, String> {
    
}
