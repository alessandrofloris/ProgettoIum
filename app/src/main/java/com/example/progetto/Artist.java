package com.example.progetto;

import java.io.Serializable;

public class Artist implements Serializable {

    // todo è necessario aggiungere al model dell'artista un campo Id
    private String nome;
    private String cognome;
    private String nomeDarte;
    private Integer imgID;
    private String dataNascita;
    private String cittaResidenza;

    private Locations regioneResidenza;
    private String generi;


    public Artist(String nome, String cognome, String nomeDarte, Integer imgID, String dataNascita, String cittaResidenza, String generi) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.imgID = imgID;
        this.dataNascita = dataNascita;
        this.regioneResidenza = Locations.NONE;
        this.cittaResidenza = cittaResidenza;
        this.generi = generi;
    }

    public Artist(String nome, String cognome, String nomeDarte) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.setImgID(0);
        this.setDataNascita("");
        this.setCittaResidenza("");
        this.setGeneri("");
    }

    public Artist(String nome, String cognome, String nomeDarte, Integer imageID) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.setImgID(imageID);
        this.setDataNascita("");
        this.setCittaResidenza("");
        this.setGeneri("");
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
        this.setNome("");
        this.setCognome("");
        this.setNomeDarte("");
        this.setImgID(0);
        this.setDataNascita("");
        this.setCittaResidenza("");
        this.setGeneri("");
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





    //Artisti
    public static Artist artist1 = new Artist("Davide", "Moi", "Rinfiggi", R.drawable.rinfiggi, "02/08/2004", "Sinnai", "Indi-Rock");
    public static Artist artist2 = new Artist("Brittany", "Sheets", "Mars Argo", R.drawable.marsargo, "20/04/1997", "Gonnesa", "Indi-Rock");
    public static Artist artist3 = new Artist("Valentina", "Luiu", "Valucre", R.drawable.valucre, "20/07/2001", "Cagliari", "Indi-pop");
    public static Artist artist4 = new Artist("Malik", "Jatar", "Mahalik", R.drawable.mahalik, "25/04/1998", "Cagliari", "Trap");
    public static Artist artist5 = new Artist("Giulia", "Corona", "Mazulco", R.drawable.mazulco, "06/09/2002", "Cagliari", "Pop");

}
