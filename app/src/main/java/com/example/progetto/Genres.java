package com.example.progetto;

import java.io.Serializable;

public enum Genres implements FiltersInterface, Serializable {
    POP("Pop"),
    Hip_HOP("Hip-Hop"),
    TECHNO("Techno"),
    JAZZ("Jazz"),
    COUNTRY("Country"),
    ROCK("Rock"),
    PROGRESSIVE_ROCK("Progressive Rock"),
    BLUES("Blues"),
    METAL("Metal"),
    HEAVY_METAL("Heavy Metal"),
    REGGAETON("Reggaeton"),
    BOSSA_NOVA("Bossa Nova"),
    INDIE_ROCK("Indie Rock"),
    INDIE_POP("Indie Pop"),
    TRAP("Trap"),
    NONE("");

    private String desc;

    Genres(String desc) {
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}