package com.example.progetto;

import java.util.ArrayList;
import java.util.List;

public class MediaRepository {

    private static MediaRepository instance;
    ArrayList<Video> rinfiggiVideoList;

    public MediaRepository() {
        rinfiggiVideoList = new ArrayList<>();

        rinfiggiVideoList.add(new Video(R.raw.rinfiggivideo1, "20/05/2023", 550, "android.resource://"+ ArtistProfile.class.getPackageName() +"/raw/rinfiggivideo1"));
        rinfiggiVideoList.add(new Video(R.raw.rinfiggivideo2, "12/12/2022", 490, "android.resource://"+ ArtistProfile.class.getPackageName() +"/raw/rinfiggivideo2"));
    }

    public static MediaRepository getInstance() {
        if(instance == null) {
            instance = new MediaRepository();
        }
        return instance;
    }

    public ArrayList<Video> getVideoList() {
       return rinfiggiVideoList;
    }

}
