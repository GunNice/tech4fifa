package br.com.tech4me.tech4fifa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4fifa.model.Jogadores;

public interface JogadoresRepository extends MongoRepository<Jogadores, String> {
    
}
