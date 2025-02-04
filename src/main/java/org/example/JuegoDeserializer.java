package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class JuegoDeserializer implements JsonDeserializer<Juego> {
    @Override
    public Juego deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jo = jsonElement.getAsJsonObject();
        Juego juego = new Juego();
        Integer id = jo.get("id").getAsInt();
        String titulo = jo.get("title").getAsString();
        String miniatura = jo.get("thumbnail").getAsString();
        String estado = jo.get("status").getAsString();
        String descripcionCorta= jo.get("short_description").getAsString();
        String descripcion = jo.get("description").getAsString();
        String url = jo.get("game_url").getAsString();
        String editor = jo.get("publisher").getAsString();
        String desarrollador = jo.get("developer").getAsString();
        LocalDate fecha = LocalDate.parse(jo.get("release_date").getAsString());





        return null;
    }
}
