package com.example.progetto;

import java.io.Serializable;

public class Artist implements Serializable {

    // todo è necessario aggiungere al model dell'artista un campo Id
    private Integer idArtist;
    private String nome;
    private String cognome;
    private String nomeDarte;
    private Integer imgID;
    private String dataNascita;
    private String cittaResidenza;

    private Locations regioneResidenza;
    private String generi;
    private String shortDesc;



    public Artist(Integer idArtist,String nome, String cognome, String nomeDarte, Integer imgID, String dataNascita, String cittaResidenza, String generi, String shortDesc) {
        this.idArtist = idArtist;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.imgID = imgID;
        this.dataNascita = dataNascita;
        this.regioneResidenza = Locations.NONE;
        this.cittaResidenza = cittaResidenza;
        this.generi = generi;
        this.shortDesc = shortDesc;
    }

    public Artist(Integer idArtist, String nome, String cognome, String nomeDarte, String shortDesc) {
        this.idArtist = idArtist;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.setImgID(0);
        this.setDataNascita("");
        this.setCittaResidenza("");
        this.setGeneri("");
        this.setShortDesc("");
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public Artist(Integer idArtist, String nome, String cognome, String nomeDarte, Integer imageID, String shortDesc) {
        this.idArtist = idArtist;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.setImgID(imageID);
        this.setDataNascita("");
        this.setCittaResidenza("");
        this.setGeneri("");
        this.setShortDesc("");
    }

    public Artist(String nome, String cognome, String nomeDarte, Integer imageID, Locations regioneResidenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.setImgID(imageID);
        this.regioneResidenza = regioneResidenza;
        this.setDataNascita("");
        this.setCittaResidenza("");
        this.setGeneri("");
    }


    static public String utenteartista = "mario";

    public Artist() {
        this.setIdArtist(0);
        this.setNome("");
        this.setCognome("");
        this.setNomeDarte("");
        this.setImgID(0);
        this.setDataNascita("");
        this.setCittaResidenza("");
        this.setGeneri("");
        this.setShortDesc("");
    }

    public Integer getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(Integer idArtist) {
        this.idArtist = idArtist;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNomeDarte() {
        return nomeDarte;
    }

    public Integer getImgID() {
        return imgID;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public String getCittaResidenza() {
        return cittaResidenza;
    }

    public String getGeneri() {
        return generi;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNomeDarte(String nomeDarte) {
        this.nomeDarte = nomeDarte;
    }

    public void setImgID(Integer imgID) {
        this.imgID = imgID;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setCittaResidenza(String cittaResidenza) {
        this.cittaResidenza = cittaResidenza;
    }

    public void setGeneri(String generi) {
        this.generi = generi;
    }

    public Locations getRegioneResidenza() {
        return regioneResidenza;
    }

    public void setRegioneResidenza(Locations regioneResidenza) {
        this.regioneResidenza = regioneResidenza;
    }
}
