package br.com.tech4me.tech4fifa.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("players")
public class Jogadores {
    @Id
    private String id;
    private String nomeJogador;
    private String pais;
    private String clube;
    private String posicao;
    private int overall;
    private int ritimo;
    private int finalizacao;
    private int passe;
    private int drible;
    private int defesa;
    private int fisico;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNomeJogador() {
        return nomeJogador;
    }
    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getClube() {
        return clube;
    }
    public void setClube(String clube) {
        this.clube = clube;
    }
    public String getPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public int getOverall() {
        return overall;
    }
    public void setOverall(int overall) {
        this.overall = overall;
    }
    public int getRitimo() {
        return ritimo;
    }
    public void setRitimo(int ritimo) {
        this.ritimo = ritimo;
    }
    public int getFinalizacao() {
        return finalizacao;
    }
    public void setFinalizacao(int finalizacao) {
        this.finalizacao = finalizacao;
    }
    public int getPasse() {
        return passe;
    }
    public void setPasse(int passe) {
        this.passe = passe;
    }
    public int getDrible() {
        return drible;
    }
    public void setDrible(int drible) {
        this.drible = drible;
    }
    public int getDefesa() {
        return defesa;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public int getFisico() {
        return fisico;
    }
    public void setFisico(int fisico) {
        this.fisico = fisico;
    }

}
