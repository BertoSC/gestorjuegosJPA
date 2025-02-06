package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JuegoDeserializer implements JsonDeserializer<Juego> {
    @Override
    public Juego deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jo = jsonElement.getAsJsonObject();
        Juego juego = new Juego();
        Integer id = jo.get("id").getAsInt();
        juego.setIdJuego(id);
        String titulo = jo.get("title").getAsString();
        juego.setTitulo(titulo);
        String miniatura = jo.get("thumbnail").getAsString();
        juego.setMiniatura(miniatura);
        String estado = jo.get("status").getAsString();
        juego.setEstado(estado);
        String descripcionCorta= jo.get("short_description").getAsString();
        juego.setDescripcionCorta(descripcionCorta);
        String descripcion = jo.get("description").getAsString();
        juego.setDescripcion(descripcion);
        String url = jo.get("game_url").getAsString();
        juego.setUrl(url);
        String editor = jo.get("publisher").getAsString();
        juego.setEditor(editor);
        String desarrollador = jo.get("developer").getAsString();
        juego.setDesarrollador(desarrollador);
        LocalDate fecha = LocalDate.parse(jo.get("release_date").getAsString());
        juego.setFecha(fecha);
        Genero genero = new Genero();
        String generoCad = jo.get("genre").getAsString();
        genero.setNombre(generoCad);
        juego.setGenero(genero);
        Plataforma plat = new Plataforma();
        String platCadena = jo.get("platform").getAsString();
        plat.setNombre(platCadena);
        juego.setPlataforma(plat);

        JsonObject joReq = jo.get("minimum_system_requirements").getAsJsonObject();
        String os = joReq.get("os").getAsString();
        String processor = joReq.get("processor").getAsString();
        String memory = joReq.get("memory").getAsString();
        String graphics = joReq.get("graphics").getAsString();
        String storage = joReq.get("storage").getAsString();
        RequisitosSistema requisitos = new RequisitosSistema();
        requisitos.setIdJuego(juego);
        requisitos.setOs(os);
        requisitos.setProcesador(processor);
        requisitos.setMemoria(memory);
        requisitos.setGraficos(graphics);
        requisitos.setAlmacenamiento(storage);
        juego.setRequisitos(requisitos);


        JsonArray ja = jo.get("screenshots").getAsJsonArray();
        List<Imagen> capturas = new ArrayList<>();
        for (JsonElement je: ja){
            JsonObject jotemp = je.getAsJsonObject();
            Imagen img = new Imagen();
            Integer idIMG = jotemp.get("id").getAsInt();
            String urlIMG = jotemp.get("image").getAsString();
            img.setJuego(juego);
            img.setIdImagen(idIMG);
            img.setUrl(urlIMG);
            try {
                img.setImagen(Imagen.urlaBytes(urlIMG));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            capturas.add(img);
        }
        juego.setImagenes(capturas);
        return juego;
    }
}
