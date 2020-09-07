package com.example.springmvc.boot;

import com.example.springmvc.model.Registry;
import com.example.springmvc.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private RegistryRepository registryRepository;

    @Autowired
    public void setProductRepository(RegistryRepository registryRepository) {
        this.registryRepository = registryRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Registry registry = new Registry();
        registry.setName("Cartório de Registro Civil São Paulo");
        registry.setAddress("Pinheiros");

        registryRepository.save(registry);

        Registry registry2 = new Registry();
        registry2.setName("Cartório de Registro Civil Rio de Janeiro");
        registry2.setAddress("Copacabana");

        registryRepository.save(registry2);
    }
}
