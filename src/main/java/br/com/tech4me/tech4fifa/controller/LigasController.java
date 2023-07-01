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


import br.com.tech4me.tech4fifa.model.Ligas;

import br.com.tech4me.tech4fifa.repository.LigasRepository;

@RestController
@RequestMapping("/ligas")
public class LigasController {
   @Autowired
   private LigasRepository repositorio;
 
   @GetMapping
   public List<Ligas> obterLigas(){
    return repositorio.findAll();
   }

   @GetMapping("/{id}")
   public Ligas consultarPorId(@PathVariable String id){
       Ligas liga = repositorio.findById(id).orElse(null); // ele procura o ID
        return liga;
   }

   @PostMapping
   public ResponseEntity<String> cadastroLiga(@RequestBody Ligas liga){
    repositorio.save(liga);
    String sms = String.format("Liga: %s da %s da %s Cadastrada com sucesso!",
    liga.getNomeLiga(), liga.getDivisao(), liga.getPaisLiga());
        return new ResponseEntity<>(sms, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLiga(@PathVariable String id){
        repositorio.existsById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public Ligas atualizarLiga(@PathVariable String id, @RequestBody Ligas novaLiga){
    Ligas antigaLiga = repositorio.findById(id).orElse(null);

     if (antigaLiga != null) {
           antigaLiga.setNomeLiga(novaLiga.getNomeLiga());
            antigaLiga.setDivisao(novaLiga.getDivisao());
            antigaLiga.setPaisLiga(novaLiga.getPaisLiga());
            repositorio.save(antigaLiga);
        }
        // devolver o produto
        return antigaLiga;


}


}
