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
        TypedQuery<Plataforma> consulta = em.createQuery("select p from Plataforma p where p.nombre = :name", Plataforma.class);
        consulta.setParameter("name", name); // Aquí se establece el parámetro
        return consulta.getSingleResult();
    }

    public Integer getIdByNamePlataforma(String name) {

            // Hacemos la consulta con un parámetro named 'name' que busca la plataforma por su nombre
            TypedQuery<Integer> query = em.createQuery(
                    "SELECT p.idPlataforma FROM Plataforma p WHERE lower(p.nombre) = lower(:name)", Integer.class);
            query.setParameter("name", name.toLowerCase()); // Establecemos el parámetro 'name'

            return query.getSingleResult(); // Recuperamos el id o lanzamos NoResultException si no se encuentra

    }

    @Override
    public void save(Plataforma plataforma) {
        em.getTransaction().begin();
        em.persist(plataforma);
        em.getTransaction().commit();
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
