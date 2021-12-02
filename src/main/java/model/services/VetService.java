package model.services;


import co.edu.unbosque.model.jpa.entities.Vet;
import co.edu.unbosque.model.jpa.repositories.UserAppRepository;
import co.edu.unbosque.model.jpa.repositories.VetRepository;
import co.edu.unbosque.model.jpa.repositories.VetRepositoryImpl;
import co.edu.unbosque.model.resources.pojos.VetPojo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class VetService {

    VetRepository vetRepository;
    UserAppRepository userAppRepository;

    public  Optional<VetPojo> saveVet(VetPojo vetPojo) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);

        Vet vet = new Vet(vetPojo.getUsername(), vetPojo.getPassword(), vetPojo.getEmail(), vetPojo.getName(),vetPojo.getAddress(),vetPojo.getNeighborhood());
        Optional<Vet> persistedVet = vetRepository.save(vet);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedVet.isPresent()) {
            return Optional.of(new VetPojo(
                    persistedVet.get().getUsername(),
                    persistedVet.get().getPassword(),
                    persistedVet.get().getEmail(),
                    persistedVet.get().getName(),
                    persistedVet.get().getAddress(),
                    persistedVet.get().getNeighborhood()));
        } else {
            return Optional.empty();
        }
    }
    public void updateVet(String username, String name, String address, String neighborhood) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        vetRepository.update(username,name,address,neighborhood);

        entityManager.close();
        entityManagerFactory.close();

    }
}
