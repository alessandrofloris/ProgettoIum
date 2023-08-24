package com.example.progetto;

import java.io.Serializable;

public class Photo implements Serializable {
    private Integer idPhoto;
    private String uploadDate;
    private Integer nLikes;


    public Photo(Integer idPhoto, String uploadDate, Integer nLikes) {
        this.idPhoto = idPhoto;
        this.uploadDate = uploadDate;
        this.nLikes = nLikes;
    }

    public Integer getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(Integer idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getnLikes() {
        return nLikes;
    }

    public void setnLikes(Integer nLikes) {
        this.nLikes = nLikes;
    }
}
