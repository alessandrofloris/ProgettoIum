package com.example.progetto;

import java.io.Serializable;

public class Audio implements Serializable {
    private Integer idAudio;
    private String uploadDate;
    private Integer durationInSec;
    private Integer nLikes;

    public Audio(Integer idAudio, String uploadDate, Integer durationInSec, Integer nLikes) {
        this.idAudio = idAudio;
        this.uploadDate = uploadDate;
        this.durationInSec = durationInSec;
        this.nLikes = nLikes;
    }

    public Integer getIdAudio() {
        return idAudio;
    }

    public void setIdAudio(Integer idAudio) {
        this.idAudio = idAudio;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getDurationInSec() {
        return durationInSec;
    }

    public void setDurationInSec(Integer durationInSec) {
        this.durationInSec = durationInSec;
    }

    public Integer getnLikes() {
        return nLikes;
    }

    public void setnLikes(Integer nLikes) {
        this.nLikes = nLikes;
    }
}
