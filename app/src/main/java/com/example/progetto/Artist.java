package com.example.progetto;

import java.io.Serializable;
import java.util.ArrayList;

public class Artist implements Serializable {

    private Integer idArtist;
    private String nome;
    private String cognome;
    private String nomeDarte;
    private Integer imgID;
    private String dataNascita;
    private String cittaResidenza;
    private Locations regioneResidenza;
    private Genres[] generi;
    private String shortDesc;
    private boolean liked;
    private ArrayList<Video> videos;
    private ArrayList<Photo> photos;
    private ArrayList<Audio> audios;


    public Artist(Integer idArtist, String nome, String cognome, String nomeDarte, Integer imgID, String dataNascita, String cittaResidenza, Locations regioneResidenza, Genres[] generi, ArrayList<Video> videos, ArrayList<Photo> photos, ArrayList<Audio> audios) {
        this.idArtist = idArtist;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.imgID = imgID;
        this.dataNascita = dataNascita;
        this.cittaResidenza = cittaResidenza;
        this.regioneResidenza = regioneResidenza;
        this.generi = generi;
        this.shortDesc = "Ciao, sono "+ getNome() +" vengo da " + getCittaResidenza() + " e faccio " + getGeneri()[0].getDesc() + ", dai un'occhiata alla mia musica!";
        this.liked = false;
        this.videos = videos;
        this.photos = photos;
        this.audios = audios;
    }

    public Artist(Integer idArtist, String nome, String cognome, String nomeDarte, Integer imgID, String dataNascita, String cittaResidenza, Locations regioneResidenza, Genres[] generi, ArrayList<Video> videos, ArrayList<Photo> photos) {
        this.idArtist = idArtist;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.imgID = imgID;
        this.dataNascita = dataNascita;
        this.cittaResidenza = cittaResidenza;
        this.regioneResidenza = regioneResidenza;
        this.generi = generi;
        this.liked = false;
        this.shortDesc = "Ciao, sono "+ getNome() +" vengo da " + getCittaResidenza() + " e faccio " + getGeneri()[0].getDesc() + ", dai un'occhiata alla mia musica!";
        this.videos = videos;
        this.photos = photos;
    }

    public Artist(Integer idArtist, String nome, String cognome, String nomeDarte, Integer imgID, String dataNascita, String cittaResidenza, Locations regione, Genres[] generi, ArrayList<Video> videos) {
        this.idArtist = idArtist;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.imgID = imgID;
        this.dataNascita = dataNascita;
        this.regioneResidenza = regione;
        this.cittaResidenza = cittaResidenza;
        this.generi = generi;
        this.shortDesc = "Ciao, sono "+ getNome() +" vengo da " + getCittaResidenza() + " e faccio " + getGeneri()[0].getDesc() + ", dai un'occhiata alla mia musica!";
        this.liked = false;
        this.videos = videos;
    }

    public Artist(Integer idArtist,String nome, String cognome, String nomeDarte, Integer imgID, String dataNascita, String cittaResidenza, Locations regione,  Genres[] generi) {
        this.idArtist = idArtist;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.imgID = imgID;
        this.dataNascita = dataNascita;
        this.regioneResidenza = regione;
        this.cittaResidenza = cittaResidenza;
        this.generi = generi;
        this.shortDesc = "Ciao, sono "+ getNome() +" vengo da " + getCittaResidenza() + " e faccio " + getGeneri()[0].getDesc() +", dai un'occhiata alla mia musica!";
        this.liked=false;
    }


    public Artist(Integer idArtist, String nome, String cognome, String nomeDarte, String shortDesc) {
        this.idArtist = idArtist;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.setImgID(0);
        this.setDataNascita("");
        this.setCittaResidenza("");
        this.setGeneri(Genres.NONE);
        this.setShortDesc("");
        this.setLiked(false);
    }



    public Artist(Integer idArtist, String nome, String cognome, String nomeDarte, Integer imageID, String shortDesc) {
        this.idArtist = idArtist;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.setImgID(imageID);
        this.setDataNascita("");
        this.setCittaResidenza("");
        this.setGeneri(Genres.NONE);
        this.setShortDesc("");
        this.setLiked(false);
    }

    public Artist(String nome, String cognome, String nomeDarte, Integer imageID, Locations regioneResidenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeDarte = nomeDarte;
        this.setImgID(imageID);
        this.regioneResidenza = regioneResidenza;
        this.setDataNascita("");
        this.setCittaResidenza("");
        this.setGeneri(Genres.NONE);
        this.liked =false;
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
        this.setRegioneResidenza(Locations.NONE);
        this.setGeneri(Genres.NONE);
        this.setShortDesc("");
        this.setLiked(false);
        this.setVideos(new ArrayList<>());
        this.setPhotos(new ArrayList<>());
        this.setAudios(new ArrayList<>());
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

    public Genres[] getGeneri() {
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

    public void setGeneri(Genres generi) {
        this.generi = new Genres[]{null, null, null};
    }

    public Locations getRegioneResidenza() {
        return regioneResidenza;
    }

    public void setRegioneResidenza(Locations regioneResidenza) {
        this.regioneResidenza = regioneResidenza;
    }
   public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
