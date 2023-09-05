package com.example.progetto;

import java.util.ArrayList;
import java.util.List;

public class ProducerRepository {

    private static ProducerRepository instance;
    List<RegistrationBean> producers;

    public ProducerRepository() {
        producers = new ArrayList<>();

        ArrayList<Locations> locations = new ArrayList<>();
        ArrayList<Genres> genres = new ArrayList<>();
        producers.add(new RegistrationBean("admin", "admin", "admin", "admin@gmial.com", "admin", locations, genres));
    }

    public void addProducer(RegistrationBean producer) {
        producers.add(producer);
    }

    public static ProducerRepository getInstance() {
        if(instance == null) {
            instance = new ProducerRepository();
        }
        return instance;
    }

    public int confermaDatiLogIn(String username, String password){
        boolean checkUsername=false;
        boolean checkPassword=false;
        int result=0;

        for (int i=0;i<producers.size();i++){
            if(producers.get(i).getUsername().equals(username))checkUsername=true;
            if(checkUsername){
                if(producers.get(i).getPassword().equals(password))checkPassword=true;
            }
        }

        if(checkPassword&&checkUsername)result=0;
        else if(checkUsername && !checkPassword) result=1;
        else if(!checkUsername && !checkPassword) result=2;

        return result;
    }

    public RegistrationBean getUtente(String username){
        int i=0;
        while (!producers.get(i).getUsername().equals(username) && i<producers.size()){
            i++;
        }
        return producers.get(i);
    }

    public List<RegistrationBean> getAllProducers() {
        return producers;
    }

    public RegistrationBean getLoggedUser() {
        return producers.get(producers.size()-1);
    }

}
