package com.example.progetto;

public class Artist {

    private String nome;
    private String cognome;
    private String nomeDarte;
    private Integer imgID;
    private String dataNascita;
    private String cittaResidenza;
    private String[] generi;
    //...

    public Artist(String nome, String cognome, String nomeDarte, Integer imgID, String dataNascita, String cittaResidenza, String[] generi) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.imgID = imgID;
        this.dataNascita = dataNascita;
        this.cittaResidenza = cittaResidenza;
        this.generi = generi;
    }

    public Artist(String nome, String cognome, String nomeDarte) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
    }

}
