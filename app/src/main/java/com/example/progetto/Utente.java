package com.example.progetto;

public class Utente {
    private String username;
    private String password;
    private String cittaProvenienza;
    private String dataDiNascita;

    public Utente (String username, String password, String cittaProvenienza, String dataDiNascita){
        this.username=username;
        this.password=password;
        this.cittaProvenienza=cittaProvenienza;
        this.dataDiNascita=dataDiNascita;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCittaProvenienza() {
        return cittaProvenienza;
    }

    public void setCittaProvenienza(String cittaProvenienza) {
        this.cittaProvenienza = cittaProvenienza;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}

