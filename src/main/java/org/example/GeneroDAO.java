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
        String nombreTrimmed = name.trim().toLowerCase();
        // Asegúrate de que no haya espacios al principio o final

        TypedQuery<Genero> consulta = em.createQuery(
                "select g from Genero g where g.nombre = :nombre", Genero.class);
        consulta.setParameter("nombre", nombreTrimmed);

        List<Genero> resultList = consulta.getResultList();
        if (resultList.isEmpty()) {
            System.out.println("No se encontró ningún resultado para: " + nombreTrimmed);
            return null;
        } else {
            return resultList.get(0);
        }
    }


    public Integer getIdByName(String name) {

            // Hacemos la consulta con un parámetro named 'name' que busca el género por su nombre
            TypedQuery<Integer> query = em.createQuery(
                    "SELECT g.idGenero FROM Genero g WHERE lower(g.nombre) = lower(:name)", Integer.class);
            query.setParameter("name", name.toLowerCase()); // Establecemos el parámetro 'name'

            return query.getSingleResult(); // Recuperamos el id o lanzamos NoResultException si no se encuentra

    }

    @Override
    public void save(Genero genero) {
        em.getTransaction().begin();
        em.persist(genero);
        em.getTransaction().commit();

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
