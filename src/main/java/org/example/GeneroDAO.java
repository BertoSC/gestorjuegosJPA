package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GeneroDAO implements DAO<Genero>{
    EntityManager em;

    GeneroDAO(EntityManager em){
        this.em=em;
    }

    @Override
    public Genero get(Integer id) {
        return null;
    }

    @Override
    public List<Genero> getAll() {
        return null;
    }

    @Override
    public Genero getByName(String name) {
        TypedQuery<Genero> consulta = em.createQuery("select g from Genero g where g.nombre=name", Genero.class);
        return consulta.getSingleResult();
    }

    @Override
    public void save(Genero genero) {

    }

    @Override
    public void update(Genero genero) {

    }

    @Override
    public void delete(Genero genero) {

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
