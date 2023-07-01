package br.com.tech4me.tech4fifa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4fifa.model.Clubs;
import br.com.tech4me.tech4fifa.repository.ClubsRepository;

@RestController
@RequestMapping("/clubs")
public class ClubsController {
   @Autowired
   private ClubsRepository repositorio;
 
   @GetMapping
   public List<Clubs> obterClubs(){
    return repositorio.findAll();
   }

   @GetMapping("/{id}")
   public Clubs consultarPorId(@PathVariable String id){
        Clubs club = repositorio.findById(id).orElse(null); // ele procura o ID
        return club;
   }

   @PostMapping
   public ResponseEntity<String> cadastroClub(@RequestBody Clubs club){
    repositorio.save(club);
    String sms = String.format("Clube: %s da Liga: %s Cadastrado com sucesso!",
    club.getNomeClub(), club.getLiga());
        return new ResponseEntity<>(sms, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerClub(@PathVariable String id){
        repositorio.existsById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public Clubs atualizarClub(@PathVariable String id, @RequestBody Clubs novoClub){
    Clubs antigoClub = repositorio.findById(id).orElse(null);

     if (antigoClub != null) {
            antigoClub.setNomeClub(novoClub.getNomeClub());
            antigoClub.setLiga(novoClub.getLiga());
            antigoClub.setSigla(novoClub.getSigla());
            repositorio.save(antigoClub);
        }
        // devolver o produto
        return antigoClub;


}


}
