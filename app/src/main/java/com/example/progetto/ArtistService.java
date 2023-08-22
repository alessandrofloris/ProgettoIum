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

    public List<Artist> searchArtistsByLocations(List<Locations> locations) {
        List<Artist> allArtists = ArtistRepository.getInstance().getAllArtists();
        List<Artist> resultArtists = new ArrayList<>();
        for(Artist artist : allArtists) {
            for(Locations location : locations) {
                if(artist.getRegioneResidenza().getDesc().equals(location.getDesc())) {
                    resultArtists.add(artist);
                    break;
                }
            }
        }

        return resultArtists;
    }

    public List<Artist> searchArtistsByGenres(List<Genres> genres) {
        List<Artist> allArtists = ArtistRepository.getInstance().getAllArtists();
        List<Artist> resultArtists = new ArrayList<>();
        for(Artist artist : allArtists) {
            for(Genres genre : genres) {
                if(artist.getRegioneResidenza().getDesc().equals(genre.getDesc())) {
                    resultArtists.add(artist);
                    break;
                }
            }
        }

        return resultArtists;
    }

    public List<Artist> filterByGenres(List<Artist> artists, List<Genres> genres) {
        List<Artist> resultArtists = new ArrayList<>();
        for(Artist artist : artists) {
            for(Genres genre : genres) {
                if(artist.getRegioneResidenza().getDesc().equals(genre.getDesc())) {
                    resultArtists.add(artist);
                    break;
                }
            }
        }

        return resultArtists;
    }

    public List<Artist> filterByLocations(List<Artist> artists, List<Locations> locations) {
        List<Artist> resultArtists = new ArrayList<>();
        for(Artist artist : artists) {
            for(Locations location : locations) {
                if(artist.getRegioneResidenza().getDesc().equals(location.getDesc())) {
                    resultArtists.add(artist);
                    break;
                }
            }
        }

        return resultArtists;
    }

}
