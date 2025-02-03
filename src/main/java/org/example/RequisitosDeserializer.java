package org.example;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class RequisitosDeserializer implements JsonDeserializer<RequisitosSistema> {
    Juego juego;

    RequisitosDeserializer(Juego juego){
        this.juego=juego;
    }

    @Override
    public RequisitosSistema deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
