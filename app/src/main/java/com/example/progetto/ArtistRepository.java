package com.example.progetto;

import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {

    private static ArtistRepository instance;
    List<Artist> artistList;

    private ArtistRepository() {
        artistList = new ArrayList<>();
        artistList.add(new Artist("marco", "rossi", "marione"));
        artistList.add(new Artist("giulio", "regeni", "regi"));
        artistList.add(new Artist("sandro", "porta", "portone magico pasoliniano"));
        artistList.add(new Artist("carla", "mora", "la diva"));
        artistList.add(new Artist("jhonna", "simoun", "simonajh"));
        artistList.add(new Artist("maurizio", "balzotti", "maurizione"));
        artistList.add(new Artist("ben", "porceddu", "potassio verde"));
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
