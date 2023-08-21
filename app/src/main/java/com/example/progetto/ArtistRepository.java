package com.example.progetto;

import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {

    private static ArtistRepository instance;
    List<Artist> artistList;

    private ArtistRepository() {
        artistList = new ArrayList<>();

        artistList.add(new Artist(0,"Davide", "Moi", "Rinfiggi", R.drawable.rinfiggi, "02/08/2004", "Sinnai", "Indi-Rock", "desc desc desc desc desc :)"));
        artistList.add(new Artist(1,"Brittany", "Sheets", "Mars Argo", R.drawable.marsargo, "20/04/1997", "Firenze", "Indi-Rock", "desc desc desc desc desc :)"));
        artistList.add(new Artist(2,"Giulia", "Corona", "Mazulco", R.drawable.mazulco, "06/09/2002", "Cagliari", "Pop", "desc desc desc desc desc :)"));
        artistList.add(new Artist(3, "Malik", "Jatar", "Mahalik", R.drawable.mahalik, "25/04/1998", "Cagliari", "Trap", "desc desc desc desc desc :)"));
        artistList.add(new Artist(4,"Valentina", "Luiu", "Valucre", R.drawable.valucre, "20/07/2001", "Cagliari", "Indi-pop", "desc desc desc desc desc :)"));
        artistList.add(new Artist(5,"Franco", "Cordini", "Sxrrxwland", R.drawable.sxrrxwland, "10/10/1997", "Padova", "Rock", "desc desc desc desc desc :)"));
        artistList.add(new Artist(6,"Emanuele", "Farina", "FunkyLemonade", R.drawable.funkylemonade, "07/07/1987", "Milano", "Jass", "desc desc desc desc desc :)"));
        artistList.add(new Artist(7,"Luca", "Bianchi", "I marciapiede", R.drawable.imarciapiede, "08/11/1999", "Bari", "Trap", "desc desc desc desc desc :)"));
        artistList.add(new Artist(8,"marco", "rossi", "The blackest", R.drawable.theblackest,"08/10/1990", "Napoli", "HeavyMetal","desc desc desc desc desc :)" ));
        artistList.add(new Artist(9,"Elisabeth", "Grant", "Lizzy Grant", R.drawable.lizzygrant, "21/06/1985", "Roma", "Indi-Rock","desc desc desc desc desc :)"));
        artistList.add(new Artist(10,"ben", "porceddu", "potassio verde",  R.drawable.potassioverde, "08/10/1990", "Genova", "Techno","desc desc desc desc desc :)"));
        artistList.add(new Artist(11,"carla", "mora", "la diva", R.drawable.billieholiday, "08/10/1990", "Firenze", "20/11/1998","desc desc desc desc desc :)"));
        artistList.add(new Artist(12,"giulio", "regeni", "SadVox", R.drawable.sadvox, "19/11/1999", "Roma", "Indi-Rock", "desc desc desc desc desc :)"));
        artistList.add(new Artist(13,"elisabetta", "ultima", "ellie",  R.drawable.ellie, "08/10/1990", "Palermo", "Jazz","desc desc desc desc desc :)"));
        artistList.add(new Artist(14,"sandro", "porta", "portone pasoliniano" ,R.drawable.portonepasoliniano, "08/10/1990", "Roma", "Pop", "desc desc desc desc desc :)"));
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
