package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
@Entity
public class Imagen {
    @Id
    Integer idImagen;
    Juego juego;
    String url;
    byte [] imagen;

    public Imagen() {
    }

    public Imagen(Juego juego, String url, byte[] imagen) {
        this.juego = juego;
        this.url = url;
        this.imagen = imagen;
    }

    public Imagen(Juego juego, String url) {
        this.juego = juego;
        this.url = url;
    }

    public Imagen(Integer idImagen, Juego juego, String url, byte[] imagen) {
        this.idImagen = idImagen;
        this.juego = juego;
        this.url = url;
        this.imagen = imagen;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public static byte[] urlaBytes(String imageUrl) throws Exception {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.connect();

        try (InputStream inputStream = connection.getInputStream();
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    @Override
    public String toString() {
        return "Imagen{" +
                "idImagen=" + idImagen +
                ", juego=" + juego +
                ", url='" + url + '\'' +
                ", imagen=" + Arrays.toString(imagen) +
                '}';
    }
}
