package model.services;

import co.edu.unbosque.model.jpa.entities.Pet;
import co.edu.unbosque.model.jpa.entities.PetCase;
import co.edu.unbosque.model.jpa.repositories.PetCaseRepository;
import co.edu.unbosque.model.jpa.repositories.PetCaseRepositoryImpl;
import co.edu.unbosque.model.jpa.repositories.PetRepository;
import co.edu.unbosque.model.jpa.repositories.PetRepositoryImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Optional;

@Stateless
public class PetCaseService {

    PetCaseRepository petCaseRepository;
    PetRepository petRepository;


    public void savePetCase(Date created_at, String type, String description, Integer pet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petCaseRepository = new PetCaseRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);

        Optional<Pet> pet = petRepository.findById(pet_id);
        pet.ifPresent(p -> {
            p.addPetCase(new PetCase(created_at, type, description));
            petRepository.save(p);
        });
        entityManager.close();
        entityManagerFactory.close();

        return;

    }


}
