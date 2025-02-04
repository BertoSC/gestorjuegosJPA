package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class ImagenDAO implements DAO<Imagen>{

    EntityManager em;

    ImagenDAO(EntityManager em){
        this.em=em;
    }

    @Override
    public Imagen get(Integer id) {
        return null;
    }

    @Override
    public List<Imagen> getAll() {
        return List.of();
    }

    @Override
    public Imagen getByName(String name) {
        return null;
    }

    @Override
    public void save(Imagen imagen) {
        em.getTransaction().begin();
        em.persist(imagen);
        em.getTransaction().commit();

    }

    @Override
    public void update(Imagen imagen) {

    }

    @Override
    public void delete(Imagen imagen) {

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
