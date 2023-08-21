package com.example.progetto;

import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {

    private static ArtistRepository instance;
    List<Artist> artistList;

    private ArtistRepository() {
        artistList = new ArrayList<>();
        artistList.add(new Artist("marco", "rossi", "marione", R.drawable.rinfiggi));
        artistList.add(new Artist("giulio", "regeni", "regi", R.drawable.marsargo));
        artistList.add(new Artist("sandro", "porta", "portone magico pasoliniano", R.drawable.valucre));
        artistList.add(new Artist("carla", "mora", "la diva", R.drawable.mahalik));
        artistList.add(new Artist("jhonna", "simoun", "simonajh", R.drawable.mazulco));
        artistList.add(new Artist("maurizio", "balzotti", "maurizione", R.drawable.mahalik));
        artistList.add(new Artist("ben", "porceddu", "potassio verde", R.drawable.rinfiggi));
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
