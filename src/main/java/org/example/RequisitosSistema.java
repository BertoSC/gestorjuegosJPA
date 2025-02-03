package org.example;

import jakarta.persistence.*;
@Entity
public class RequisitosSistema {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "idJuego")
    Juego idJuego;
    String almacenamiento;
    String graficos;
    String memoria;
    String os;
    String procesador;

    public RequisitosSistema() {
    }

    public RequisitosSistema(String almacenamiento, String graficos, String memoria, String os, String procesador) {
        this.almacenamiento = almacenamiento;
        this.graficos = graficos;
        this.memoria = memoria;
        this.os = os;
        this.procesador = procesador;
    }

    public RequisitosSistema(Juego idJuego, String almacenamiento, String graficos, String memoria, String os, String procesador) {
        this.idJuego = idJuego;
        this.almacenamiento = almacenamiento;
        this.graficos = graficos;
        this.memoria = memoria;
        this.os = os;
        this.procesador = procesador;
    }

    public Juego getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Juego idJuego) {
        this.idJuego = idJuego;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getGraficos() {
        return graficos;
    }

    public void setGraficos(String graficos) {
        this.graficos = graficos;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    @Override
    public String toString() {
        return "RequisitosSistema{" +
                "idJuego=" + idJuego +
                ", almacenamiento='" + almacenamiento + '\'' +
                ", graficos='" + graficos + '\'' +
                ", memoria='" + memoria + '\'' +
                ", os='" + os + '\'' +
                ", procesador='" + procesador + '\'' +
                '}';
    }
}


