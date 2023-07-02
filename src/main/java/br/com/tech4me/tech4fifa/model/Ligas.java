package br.com.tech4me.tech4fifa.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("campeonatos")
public class Ligas {
    @Id
    private String id;
    private String nomeLiga;
    private String paisLiga;
    private String divisao;

    public Ligas() {
    }

    public Ligas(String nomeLiga) {
        this.nomeLiga = nomeLiga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeLiga() {
        return nomeLiga;
    }

    public void setNomeLiga(String nomeLiga) {
        this.nomeLiga = nomeLiga;
    }

    public String getPaisLiga() {
        return paisLiga;
    }

    public void setPaisLiga(String paisLiga) {
        this.paisLiga = paisLiga;
    }

    public String getDivisao() {
        return divisao;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }
}
