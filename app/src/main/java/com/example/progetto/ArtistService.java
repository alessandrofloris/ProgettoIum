package com.example.progetto;

import android.util.Log;

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
        nickname = nickname.toLowerCase();
        List<Artist> allArtists = ArtistRepository.getInstance().getAllArtists();
        List<Artist> resultArtists = new ArrayList<>();
        for(Artist artist : allArtists) {
            if(artist.getNomeDarte().toLowerCase().startsWith(nickname)) {
                resultArtists.add(artist);
            }
        }

        return resultArtists;
    }

    public Artist getById(Integer id) {
        List<Artist> allArtists = ArtistRepository.getInstance().getAllArtists();
        for(Artist artist : allArtists)
            if(artist.getIdArtist() == id)
                return artist;

        return null;
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
        Boolean added = false;
        for(Artist artist : allArtists) {
            added = false;
            for(Genres genre : genres) {
                if(added) break;
                for(Genres artistGenre : artist.getGeneri()) {
                    if(artistGenre.getDesc().equals(genre.getDesc())) {
                        resultArtists.add(artist);
                        added = true;
                        break;
                    }
                }
            }
        }
        return resultArtists;
    }

    public List<Artist> filterByGenres(List<Artist> artists, List<Genres> genres) {
        List<Artist> resultArtists = new ArrayList<>();
        Boolean added = false;
        for(Artist artist : artists) {
            added = false;
            for(Genres artistGenre : artist.getGeneri()) {
                if(added) break;
                for(Genres genre : genres) {
                    if(artistGenre.getDesc().equals(genre.getDesc())) {
                        resultArtists.add(artist);
                        added = true;
                        Log.d("GENRE FILTER", artist.getNomeDarte());
                        break;
                    }
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

    public List<Artist> getLikedArtists() {
        List<Artist> allArtists = ArtistRepository.getInstance().getAllArtists();
        List<Artist> resultArtists = new ArrayList<>();
        for(Artist artist : allArtists) {
            if(artist.isLiked()) {
                resultArtists.add(artist);
            }
        }

        return resultArtists;
    }

    public List<Artist> getTextedArtists() {
        List<Artist> allArtists = ArtistRepository.getInstance().getAllArtists();
        List<Artist> resultArtists = new ArrayList<>();
        for(Artist artist : allArtists) {
            if(artist.isTexted()) {
                resultArtists.add(artist);
            }
        }

        return resultArtists;
    }


    public List<Artist> getPopularArtists() {
        List<Artist> resultArtists = new ArrayList<>();
        //Per adesso prendo i primi 6 artisti, poi ci pensiamo
        for(int i=0; i<=5; i++) {
            resultArtists.add(getById(i));
        }
        return resultArtists;
    }

}
