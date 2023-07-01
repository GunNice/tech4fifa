package br.com.tech4me.tech4fifa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4fifa.model.Ligas;

public interface LigasRepository extends MongoRepository<Ligas, String> {
    
}
