package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Plataforma {
    @Id
    Integer idPlataforma;
    String nombre;

    public Plataforma() {
    }

    public Plataforma(Integer idPlataforma, String nombre) {
        this.idPlataforma = idPlataforma;
        this.nombre = nombre;
    }

    public Plataforma(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Integer idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "idPlataforma=" + idPlataforma +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
