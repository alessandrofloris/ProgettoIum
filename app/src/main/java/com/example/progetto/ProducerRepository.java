package com.example.progetto;

import java.util.ArrayList;
import java.util.List;

public class ProducerRepository {

    private static ProducerRepository instance;
    List<RegistrationBean> producers;

    public ProducerRepository() {
        producers = new ArrayList<>();

        producers.add(new RegistrationBean("admin", "admin", "admin", "admin@gmial.com"));
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

    public List<RegistrationBean> getAllProducers() {
        return producers;
    }

}
