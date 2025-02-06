package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class RequisitosDAO implements DAO<RequisitosSistema>{
    EntityManager em;

    public RequisitosDAO(EntityManager em){
        this.em=em;
    }



    @Override
    public RequisitosSistema get(Integer id) {
        return null;
    }

    @Override
    public List<RequisitosSistema> getAll() {
        return List.of();
    }

    @Override
    public RequisitosSistema getByName(String name) {
        return null;
    }

    @Override
    public void save(RequisitosSistema requisitosSistema) {
        em.getTransaction().begin();
        em.persist(requisitosSistema);
        em.getTransaction().commit();

    }

    @Override
    public void update(RequisitosSistema requisitosSistema) {

    }

    @Override
    public void delete(RequisitosSistema requisitosSistema) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Long> getAllIds() {
        return List.of();
    }

    @Override
    public void deleteAll() {

    }
}
