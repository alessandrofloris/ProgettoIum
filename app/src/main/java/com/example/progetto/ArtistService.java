package com.example.progetto;

import java.util.List;

public class ArtistService {

    private static ArtistService instance;

    private ArtistService() {}

    public static ArtistService getInstance() {
        if(instance == null) {
            instance = new ArtistService();
        }
        return instance;
    }

    public List<Artist> getAllArtist() {
        return ArtistRepository.getInstance().getAllArtists();
    }
}
