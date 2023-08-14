package com.example.progetto;
import java.util.ArrayList;
import java.util.Collections;


public class DataBase {
    static public ArrayList<Utente> listaUtenti = new ArrayList<>();
    static public String utenteLoggato = "admin";

    static void addUtente(Utente nuovoUtente){
        listaUtenti.add(nuovoUtente);
    }

    static boolean cercaUtenteUsername(String username){
        for(int i=0;i<listaUtenti.size();i++){
            if(listaUtenti.get(i).getUsername().equals(username)) return  true;
        }
        return  false;
    }

    static public int confermaDatiLogIn(String username, String password){
        boolean checkUsername=false;
        boolean checkPassword=false;
        int result=0;

        for (int i=0;i<listaUtenti.size();i++){
            if(listaUtenti.get(i).getUsername().equals(username))checkUsername=true;
            if(checkUsername){
                if(listaUtenti.get(i).getPassword().equals(password))checkPassword=true;
            }
        }

        if(checkPassword&&checkUsername)result=0;
        else if(checkUsername && !checkPassword) result=1;
        else if(!checkUsername && !checkPassword) result=2;

        return result;
    }

    static public Utente getUtente(String username){
        int i=0;
        while (!listaUtenti.get(i).getUsername().equals(username) && i<listaUtenti.size()){
            i++;
        }
        return listaUtenti.get(i);
    }

}
