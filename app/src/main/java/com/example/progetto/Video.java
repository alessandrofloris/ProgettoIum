package com.example.progetto;

import java.io.Serializable;
import java.util.ArrayList;

public class Video implements Serializable {
    private Integer idVideo;
    private String uploadDate;
    private Integer nLikes;
    private String vPath;

    public Video(Integer idVideo, String uploadDate, Integer nLikes, String vPath) {
        this.idVideo = idVideo;
        this.uploadDate = uploadDate;
        this.nLikes = nLikes;
        this.vPath = vPath;
    }

    public Integer getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Integer idVideo) {
        this.idVideo = idVideo;
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

    public String getvPath() {
        return vPath;
    }

    public void setvPath(String vPath) {
        this.vPath = vPath;
    }

}
