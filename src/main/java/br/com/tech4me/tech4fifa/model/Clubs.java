package br.com.tech4me.tech4fifa.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("clubs")
public class Clubs {
 @Id
 private String id;
 private String nomeClub;
 private Ligas liga;
 private String sigla;


public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getNomeClub() {
    return nomeClub;
}
public void setNomeClub(String nomeClub) {
    this.nomeClub = nomeClub;
}

public String getSigla() {
    return sigla;
}
public void setSigla(String sigla) {
    this.sigla = sigla;
}

public Ligas getLiga() {
    return liga;
}
public void setLiga(Ligas liga) {
    this.liga = liga;
}  
}
