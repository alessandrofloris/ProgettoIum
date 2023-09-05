package com.example.progetto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegistrationBean implements Serializable {

    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private List<String> locations;
    private List<Genres> genres;

    public RegistrationBean() {
        locations = new ArrayList<>();
        genres = new ArrayList<>();
    }

    public RegistrationBean(String name, String surname, String username, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        locations = new ArrayList<>();
        genres = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public ArrayList<Genres> getGenres() {
        return (ArrayList<Genres>) genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }
}
