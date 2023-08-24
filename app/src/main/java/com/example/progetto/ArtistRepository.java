package com.example.progetto;

import java.util.ArrayList;
import java.util.List;


public class ArtistRepository {

    private static ArtistRepository instance;
    List<Artist> artistList;

    public ArtistRepository() {
        artistList = new ArrayList<>();

        ArrayList<Video> videoList = new ArrayList<>();
        videoList.add(new Video(R.raw.rinfiggivideo2, "12/09/2023", 270, "android.resource://"+ ArtistProfile.class.getPackageName() +"/raw/rinfiggivideo2"));
        videoList.add(new Video(R.raw.rinfiggivideo1, "20/05/2023", 550, "android.resource://"+ ArtistProfile.class.getPackageName() +"/raw/rinfiggivideo1"));
        videoList.add(new Video(R.raw.rinfiggivideo2, "06/12/2022", 390, "android.resource://"+ ArtistProfile.class.getPackageName() +"/raw/rinfiggivideo2"));

        ArrayList<Photo> photoList = new ArrayList<>();
        photoList.add(new Photo(R.drawable.artist1, "20/03/2021", 300));
        photoList.add(new Photo(R.drawable.artist2, "20/03/2021", 300));
        photoList.add(new Photo(R.drawable.billieholiday, "20/03/2021", 300));

        ArrayList<Audio> audioList = new ArrayList<>();
        audioList.add(new Audio(R.raw.audiotest, "19/11/2020", 45, 300));

        artistList.add(new Artist(0,"Davide", "Moi", "Rinfiggi", R.drawable.rinfiggi, "02/08/2004", "Sinnai", Locations.EMILIA_ROMAGNA, Genres.INDIE_ROCK, videoList, photoList, audioList));
        artistList.add(new Artist(1,"Brittany", "Sheets", "Mars Argo", R.drawable.marsargo, "20/04/1997", "Firenze", Locations.TOSCANA, Genres.INDIE_ROCK,videoList));
        artistList.add(new Artist(2,"Giulia", "Corona", "Mazulco", R.drawable.mazulco, "06/09/2002", "Cagliari", Locations.SARDEGNA,  Genres.POP,videoList));
        artistList.add(new Artist(3, "Malik", "Jatar", "Mahalik", R.drawable.mahalik, "25/04/1998", "Cagliari", Locations.SARDEGNA, Genres.TRAP));
        artistList.add(new Artist(4,"Valentina", "Luiu", "Valucre", R.drawable.valucre, "20/07/2001", "Cagliari", Locations.SARDEGNA, Genres.INDIE_POP));
        artistList.add(new Artist(5,"Franco", "Cordini", "Sxrrxwland", R.drawable.sxrrxwland, "10/10/1997", "Padova", Locations.VENETO, Genres.ROCK));
        artistList.add(new Artist(6,"Emanuele", "Farina", "FunkyLemonade", R.drawable.funkylemonade, "07/07/1987", "Milano", Locations.LOMBARDIA, Genres.JAZZ));
        artistList.add(new Artist(7,"Luca", "Bianchi", "I marciapiede", R.drawable.imarciapiede, "08/11/1999", "Bari", Locations.PUGLIA, Genres.TRAP));
        artistList.add(new Artist(8,"marco", "rossi", "The blackest", R.drawable.theblackest,"08/10/1990", "Napoli", Locations.CAMPANIA, Genres.HEAVY_METAL));
        artistList.add(new Artist(9,"Elisabeth", "Grant", "Lizzy Grant", R.drawable.lizzygrant, "21/06/1985", "Roma", Locations.LAZIO, Genres.INDIE_ROCK));
        artistList.add(new Artist(10,"ben", "porceddu", "potassio verde",  R.drawable.potassioverde, "08/10/1990", "Genova", Locations.LIGURIA, Genres.TECHNO));
        artistList.add(new Artist(11,"carla", "mora", "la diva", R.drawable.billieholiday, "08/10/1990", "Firenze", Locations.TOSCANA, Genres.HEAVY_METAL));
        artistList.add(new Artist(12,"giulio", "regeni", "SadVox", R.drawable.sadvox, "19/11/1999", "Roma", Locations.LAZIO, Genres.INDIE_ROCK));
        artistList.add(new Artist(13,"elisabetta", "ultima", "ellie",  R.drawable.ellie, "08/10/1990", "Palermo", Locations.SICILIA, Genres.JAZZ));
        artistList.add(new Artist(14,"sandro", "porta", "portone pasoliniano" ,R.drawable.portonepasoliniano, "08/10/1990", "Roma", Locations.LAZIO, Genres.POP));
        artistList.add(new Artist(15, "ximena", "sarinana", "ximena", R.drawable.ximena, "27/12/1999", "Sassari", Locations.SARDEGNA, Genres.POP));
        artistList.add(new Artist(16, "silvana", "estrada", "silvana", R.drawable.silvana, "14/01/2001", "Ozieri", Locations.SARDEGNA, Genres.POP));
    }


    public static ArtistRepository getInstance() {
        if(instance == null) {
            instance = new ArtistRepository();
        }
        return instance;
    }

    public List<Artist> getAllArtists() {
        return artistList;
    }

}
