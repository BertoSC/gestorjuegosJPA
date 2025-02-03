package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PlataformaDAO implements DAO<Plataforma>{
    EntityManager em;
    PlataformaDAO(EntityManager em){
        this.em=em;
    }
    @Override
    public Plataforma get(Integer id) {
        return null;
    }

    @Override
    public List<Plataforma> getAll() {
        return null;
    }

    @Override
    public Plataforma getByName(String name) {
        TypedQuery<Plataforma> consulta = em.createQuery("select p from Plataforma p where p.nombre=name", Plataforma.class);
        return consulta.getSingleResult();
    }

    @Override
    public void save(Plataforma plataforma) {

    }

    @Override
    public void update(Plataforma plataforma) {

    }

    @Override
    public void delete(Plataforma plataforma) {

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
