package com.example.progetto;

import java.util.ArrayList;
import java.util.List;


public class ArtistRepository {

    private static ArtistRepository instance;
    List<Artist> artistList;

    public ArtistRepository() {
        artistList = new ArrayList<>();

        ArrayList<Video> videoList = new ArrayList<>();
        videoList.add(new Video(R.raw.rinfiggivideo1, "12/09/2023", 270, "android.resource://"+ ArtistProfile.class.getPackageName() +"/raw/rinfiggivideo1"));
        videoList.add(new Video(R.raw.rinfiggivideo1, "20/05/2023", 550, "android.resource://"+ ArtistProfile.class.getPackageName() +"/raw/rinfiggivideo1"));
        videoList.add(new Video(R.raw.rinfiggivideo1, "06/12/2022", 390, "android.resource://"+ ArtistProfile.class.getPackageName() +"/raw/rinfiggivideo1"));

        ArrayList<Photo> rinfiggiPhotoList = new ArrayList<>();
        rinfiggiPhotoList.add(new Photo(R.drawable.rinfiggiphoto3, "20/03/2023", 560));
        rinfiggiPhotoList.add(new Photo(R.drawable.rinfiggiphoto2, "18/01/2023", 409));
        rinfiggiPhotoList.add(new Photo(R.drawable.rinfiggiphoto1, "20/11/2022", 339));

        ArrayList<Audio> audioList = new ArrayList<>();
        audioList.add(new Audio("Valentine's day", R.raw.audiotest, "30/01/2022", 45, 560));
        audioList.add(new Audio("Tyler", R.raw.audiotest2, "19/11/2020", 33, 300));
        audioList.add(new Audio("Voicemail", R.raw.audiotest, "19/10/2029", 26, 208));


        artistList.add(new Artist(0,"Davide", "Moi", "Rinfiggi", R.drawable.rinfiggi, "02/08/2004", "Sinnai", Locations.EMILIA_ROMAGNA, new Genres[]{Genres.INDIE_ROCK, Genres.ROCK, Genres.POP, Genres.JAZZ}, videoList, rinfiggiPhotoList, audioList));
        artistList.add(new Artist(1,"Brittany", "Sheets", "Mars Argo", R.drawable.marsargo, "20/04/1997", "Firenze", Locations.TOSCANA, new Genres[]{Genres.INDIE_ROCK, Genres.BLUES},videoList));
        artistList.add(new Artist(2,"Giulia", "Corona", "Mazulco", R.drawable.mazulco, "06/09/2002", "Cagliari", Locations.SARDEGNA,  new Genres[]{Genres.POP, Genres.INDIE_POP},videoList));
        artistList.add(new Artist(3, "Malik", "Jatar", "Mahalik", R.drawable.mahalik, "25/04/1998", "Cagliari", Locations.SARDEGNA, new Genres[]{Genres.TRAP, Genres.ROCK}));
        artistList.add(new Artist(4,"Valentina", "Luiu", "Valucre", R.drawable.valucre, "20/07/2001", "Cagliari", Locations.SARDEGNA, new Genres[]{Genres.INDIE_POP, Genres.COUNTRY, Genres.BLUES}));
        artistList.add(new Artist(5,"Franco", "Cordini", "Sxrrxwland", R.drawable.sxrrxwland, "10/10/1997", "Padova", Locations.VENETO, new Genres[]{Genres.ROCK, Genres.INDIE_ROCK}));
        artistList.add(new Artist(6,"Emanuele", "Farina", "FunkyLemonade", R.drawable.funkylemonade, "07/07/1987", "Milano", Locations.LOMBARDIA, new Genres[]{Genres.JAZZ, Genres.BOSSA_NOVA}));
        artistList.add(new Artist(7,"Luca", "Bianchi", "I marciapiede", R.drawable.imarciapiede, "08/11/1999", "Bari", Locations.PUGLIA, new Genres[]{Genres.TRAP, Genres.Hip_HOP, Genres.ROCK, Genres.BOSSA_NOVA}));
        artistList.add(new Artist(8,"marco", "rossi", "The blackest", R.drawable.theblackest,"08/10/1990", "Napoli", Locations.CAMPANIA, new Genres[]{Genres.HEAVY_METAL }));
        artistList.add(new Artist(9,"Elisabeth", "Grant", "Lizzy Grant", R.drawable.lizzygrant, "21/06/1985", "Roma", Locations.LAZIO, new Genres[]{Genres.INDIE_ROCK, Genres.POP, Genres.JAZZ, Genres.INDIE_POP}));
        artistList.add(new Artist(10,"ben", "porceddu", "potassio verde",  R.drawable.potassioverde, "08/10/1990", "Genova", Locations.LIGURIA, new Genres[]{Genres.TECHNO}));
        artistList.add(new Artist(11,"carla", "mora", "la diva", R.drawable.billieholiday, "08/10/1990", "Firenze", Locations.TOSCANA, new Genres[]{Genres.HEAVY_METAL, Genres.ROCK}));
        artistList.add(new Artist(12,"giulio", "regeni", "SadVox", R.drawable.sadvox, "19/11/1999", "Roma", Locations.LAZIO, new Genres[]{Genres.INDIE_ROCK}));
        artistList.add(new Artist(13,"elisabetta", "ultima", "ellie",  R.drawable.ellie, "08/10/1990", "Palermo", Locations.SICILIA, new Genres[]{Genres.JAZZ, Genres.ROCK}));
        artistList.add(new Artist(14,"sandro", "porta", "portone pasoliniano" ,R.drawable.portonepasoliniano, "08/10/1990", "Roma", Locations.LAZIO, new Genres[]{Genres.POP}));
        artistList.add(new Artist(15, "ximena", "sarinana", "ximena", R.drawable.ximena, "27/12/1999", "Sassari", Locations.SARDEGNA, new Genres[]{Genres.POP}));
        artistList.add(new Artist(16, "silvana", "estrada", "silvana", R.drawable.silvana, "14/01/2001", "Ozieri", Locations.SARDEGNA, new Genres[]{Genres.POP}));
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
