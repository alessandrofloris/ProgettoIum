package com.example.progetto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Artist> searchArtistsByPartialNickName(String nickname) {
        List<Artist> allArtists = ArtistRepository.getInstance().getAllArtists();
        List<Artist> resultArtists = new ArrayList<>();
        for(Artist artist : allArtists) {
            if(artist.getNomeDarte().startsWith(nickname)) {
                resultArtists.add(artist);
            }
        }

        return resultArtists;
    }
}
