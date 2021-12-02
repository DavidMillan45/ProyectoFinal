package model.jpa.repositories;

import model.jpa.entities.Pet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetRepositoryImpl implements PetRepository {

    private EntityManager entityManager;

    public PetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Optional<Pet> findById(Integer id) {
        Pet pet = entityManager.find(Pet.class, id);
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    public List<Pet> findAll() {
        return entityManager.createQuery("from Pet").getResultList();
    }

    public Optional<Pet> update(Integer pet_id, String name, String species, String race, String size, String sex, String picture) {
        try {
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, pet_id);
            pet.setName(name);
            pet.setEspecies(species);
            pet.setRace(race);
            pet.setSize(size);
            pet.setSex(sex);
            pet.setPicture(picture);
            entityManager.getTransaction().commit();
            return Optional.of(pet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Pet> updateMicrochip(Integer pet_id, String microchp) {
        try {
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, pet_id);
            pet.setMicrochip(microchp);
            entityManager.getTransaction().commit();
            return Optional.of(pet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }


    public Optional<Pet> save(Pet pet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pet);
            entityManager.getTransaction().commit();
            return Optional.of(pet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
