package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class APPGame {
    public static final String URL_API = "https://www.freetogame.com/api/game?id=";
    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner sc = new Scanner(System.in);
        menuApp(sc);

    }

    private static String obtenerJson(String id) throws URISyntaxException, IOException {
        URL url = new URI(URL_API+id).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        StringBuilder json = new StringBuilder();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Juego.class, new JuegoDeserializer())
                .create();
        if (connection.getResponseCode()==HttpURLConnection.HTTP_OK){
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String linea;
            while ((linea = br.readLine())!= null){
                json.append(linea);
            }
        }

        return json.toString();
    }

    private static void menuApp(Scanner sc) throws IOException, URISyntaxException {
        System.out.println("GESTOR DE JUEGOS GRATUITOS");
        System.out.println();
        System.out.println("Introduce el id del juego que quieres buscar");
        String juegoBuscado = sc.nextLine();
        String json = obtenerJson(juegoBuscado);
        System.out.println(json);

    }
}