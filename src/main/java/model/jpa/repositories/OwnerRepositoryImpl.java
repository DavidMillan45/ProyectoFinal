package model.jpa.repositories;

import model.jpa.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OwnerRepositoryImpl implements OwnerRepository {

    private EntityManager entityManager;

    public OwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    public List<Owner> findAll() {
        return entityManager.createQuery("from Owner").getResultList();
    }

    public Optional<Owner> update(String userame, String email,String name, String address, String neighborhood) {

        try {
            entityManager.getTransaction().begin();

            Owner owner = entityManager.find(Owner.class, userame);
            owner.setName(name);
            owner.setEmail(email);
            owner.setAddress(address);
            owner.setNeighborhood(neighborhood);


            //entityManager.update(owner); // Revisar si esto es obligatorio
            entityManager.getTransaction().commit();

            return Optional.of(owner);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Owner> save(Owner owner) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(owner);
            entityManager.getTransaction().commit();
            return Optional.of(owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}