package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class JuegoDAO implements DAO<Juego>{
    EntityManager em;

    JuegoDAO(EntityManager em){
        this.em=em;
    }

    @Override
    public Juego get(Integer id) {
        return null;
    }

    @Override
    public List<Juego> getAll() {
        return null;
    }

    @Override
    public Juego getByName(String name) {
        return null;
    }

    @Override
    public void save(Juego juego) {
        em.getTransaction().begin();
        em.persist(juego);
        em.getTransaction().commit();

    }

    @Override
    public void update(Juego juego) {
    }

    @Override
    public void delete(Juego juego) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Long> getAllIds() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
