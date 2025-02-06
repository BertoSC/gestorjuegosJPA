package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Juego {
    @Id
    Integer idJuego;
    @OneToOne
    @JoinColumn(name = "idGenero", foreignKey = @ForeignKey(name = "idGenero"))
    Genero genero;
    @OneToOne
    @JoinColumn(name = "idPlataforma", foreignKey = @ForeignKey(name = "idPlataforma"))
    Plataforma plataforma;
    String titulo;
    String miniatura;
    String estado;
    String descripcionCorta;
    @Column(length = 10000)
    String descripcion;
    String url;
    String editor;
    String desarrollador;
    LocalDate fecha;
    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Imagen> imagenes;
    @Transient
    RequisitosSistema requisitos;

    public Juego() {
    }

    public Juego(Genero genero, Plataforma plataforma, String titulo, String miniatura, String estado, String descripcionCorta, String descripcion, String url, String editor, String desarrollador, LocalDate fecha) {
        this.genero = genero;
        this.plataforma = plataforma;
        this.titulo = titulo;
        this.miniatura = miniatura;
        this.estado = estado;
        this.descripcionCorta = descripcionCorta;
        this.descripcion = descripcion;
        this.url = url;
        this.editor = editor;
        this.desarrollador = desarrollador;
        this.fecha = fecha;
    }

    public Juego(Integer idJuego, Genero genero, Plataforma plataforma, String titulo, String miniatura, String estado, String descripcionCorta, String descripcion, String url, String editor, String desarrollador, LocalDate fecha) {
        this.idJuego = idJuego;
        this.genero = genero;
        this.plataforma = plataforma;
        this.titulo = titulo;
        this.miniatura = miniatura;
        this.estado = estado;
        this.descripcionCorta = descripcionCorta;
        this.descripcion = descripcion;
        this.url = url;
        this.editor = editor;
        this.desarrollador = desarrollador;
        this.fecha = fecha;
    }

    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(String miniatura) {
        this.miniatura = miniatura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public RequisitosSistema getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(RequisitosSistema requisitos) {
        this.requisitos = requisitos;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "idJuego=" + idJuego +
                ", genero=" + genero +
                ", plataforma=" + plataforma +
                ", titulo='" + titulo + '\'' +
                ", miniatura='" + miniatura + '\'' +
                ", estado='" + estado + '\'' +
                ", descripcionCorta='" + descripcionCorta + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", url='" + url + '\'' +
                ", editor='" + editor + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
