package com.example.progetto;

public enum Locations {
    ABRUZZO("Abruzzo"),
    BASILICATA("Basilicata"),
    CALABRIA("Calabria"),
    CAMPANIA("Campania"),
    EMILIA_ROMAGNA("Emilia Romagna"),
    FRIULI_VENEZIA_GIULIA("Friuli Venezia Giulia"),
    LAZIO("Lazio"),
    LIGURIA("Liguria"),
    LOMBARDIA("Lombardia"),
    MARCHE("Marche"),
    MOLISE("Molise"),
    PIEMONTE("Piemonte"),
    PUGLIA("Puglia"),
    SARDEGNA("Sardegna"),
    SICILIA("Sicilia"),
    TOSCANA("Toscana"),
    TRENTINO_ALTO_ADIGE("Trentino Alto Adige"),
    UMBIRIA("Umbria"),
    VAL_D_AOSTA("Valle da Osta"),
    VENETO("Veneto"),
    PROVINCIA_AUTONOMA_DI_TRENTO("Provincia autonoma di Trento"),
    PROVINCIA_AUTONOMA_DI_BOLZANO("Provincia autonoma di Bolzano"),
    NONE("");

    private String desc;

    Locations(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}