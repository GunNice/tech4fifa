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
import br.com.tech4me.tech4fifa.model.Jogadores;
import br.com.tech4me.tech4fifa.repository.JogadoresRepository;

@RestController
@RequestMapping("/jogadores")
public class JogadoresController {
   @Autowired
   private JogadoresRepository repositorio;

    @GetMapping
    public List<Jogadores> obterJogadores(){
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Jogadores consultaPorId(@PathVariable String id){
        Jogadores jogador = repositorio.findById(id).orElse(null);

        return jogador;
    }

    @PostMapping
    public ResponseEntity<String> cadastroJogador(@RequestBody Jogadores jogador){
        repositorio.save(jogador);
        String mensagem = String.format("Jogador: %s - Posição: %s  com Over: %s  Cadastrado com sucesso",
         jogador.getNomeJogador(), jogador.getPosicao(), jogador.getOverall());

         return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerJogador(@PathVariable String id){
        repositorio.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

     @PutMapping("/{id}")
    public Jogadores atualizarJogador(@PathVariable String id, @RequestBody Jogadores novoJogador) {
        // Localizar
        Jogadores antigoJogador = repositorio.findById(id).orElse(null);

        // Atualizar
        if (antigoJogador != null) {
            antigoJogador.setNomeJogador(novoJogador.getNomeJogador());
            antigoJogador.setPais(novoJogador.getPais());
            antigoJogador.setClube(novoJogador.getClube());
            antigoJogador.setPosicao(novoJogador.getPosicao());
            antigoJogador.setOverall(novoJogador.getOverall());
            antigoJogador.setRitimo(novoJogador.getRitimo());
            antigoJogador.setFinalizacao(novoJogador.getFinalizacao());
            antigoJogador.setPasse(novoJogador.getPasse());
            antigoJogador.setDrible(novoJogador.getDrible());
            antigoJogador.setPais(novoJogador.getPais());
            antigoJogador.setDefesa(novoJogador.getDefesa());
            antigoJogador.setFisico(novoJogador.getFisico());
            repositorio.save(antigoJogador);
        }
        // devolver o produto
        return antigoJogador;
    }
}






