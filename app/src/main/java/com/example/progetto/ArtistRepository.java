package com.example.progetto;

import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {

    private static ArtistRepository instance;
    List<Artist> artistList;

    private ArtistRepository() {
        artistList = new ArrayList<>();
        artistList.add(new Artist("marco", "rossi", "marione", R.drawable.rinfiggi, Locations.SARDEGNA));
        artistList.add(new Artist("giulio", "regeni", "regi", R.drawable.marsargo, Locations.EMILIA_ROMAGNA));
        artistList.add(new Artist("sandro", "porta", "portone magico pasoliniano", R.drawable.valucre, Locations.EMILIA_ROMAGNA));
        artistList.add(new Artist("carla", "mora", "la diva", R.drawable.mahalik, Locations.MOLISE));
        artistList.add(new Artist("jhonna", "simoun", "simonajh", R.drawable.mazulco, Locations.EMILIA_ROMAGNA));
        artistList.add(new Artist("maurizio", "balzotti", "maurizione", R.drawable.mahalik, Locations.BASILICATA));
        artistList.add(new Artist("ben", "porceddu", "potassio verde", R.drawable.rinfiggi, Locations.SARDEGNA));
        artistList.add(new Artist("ximena", "sarinana", "ximena", R.drawable.ximena, Locations.SARDEGNA));
        artistList.add(new Artist("silvana", "estrada", "silvana", R.drawable.silvana, Locations.SARDEGNA));
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
