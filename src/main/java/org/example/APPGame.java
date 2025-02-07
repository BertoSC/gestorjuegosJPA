package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Scanner;

public class APPGame {
    public static final String URL_API = "https://www.freetogame.com/api/game?id=";
    static EntityManagerFactory emf = JpaGameManager.getEntityManagerFactory(JpaGameManager.GAME_H2);
    static EntityManager em = JpaGameManager.getEntityManager(JpaGameManager.GAME_H2);
    static GeneroDAO generoDAO = new GeneroDAO(em);
    static PlataformaDAO plataformaDAO = new PlataformaDAO(em);
    static RequisitosDAO requisitosDAO = new RequisitosDAO(em);
    static ImagenDAO imagenDAO = new ImagenDAO(em);
    static JuegoDAO juegoDAO = new JuegoDAO(em);

    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner sc = new Scanner(System.in);
        menuApp(sc);

    }

    private static String obtenerJson(String id) throws URISyntaxException, IOException {
        URL url = new URI(URL_API+id).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        StringBuilder json = new StringBuilder();
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
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Juego.class, new JuegoDeserializer())
                .create();
        //System.out.println(json);

        Juego juego = gson.fromJson(json, Juego.class);
        //System.out.println(juego);
        //RequisitosSistema req = juego.getRequisitos();
        //System.out.println(req);

        if (persistirJuego(juego)){
            System.out.println("Juego almacenado con éxito");
        } else {
            System.out.println("ERROR EN EL PROCESO");
        };

    }

    private static Boolean persistirJuego(Juego juego) {
        Genero tempGen = juego.getGenero();
        generoDAO.save(tempGen);
        Plataforma tempPlat = juego.getPlataforma();
        plataformaDAO.save(tempPlat);
        juegoDAO.save(juego);

        List<Imagen> imagenes = juego.getImagenes();
        for (Imagen img: imagenes){
            imagenDAO.save(img);
        }

        RequisitosSistema req = juego.getRequisitos();
        requisitosDAO.save(req);

        return true;
    }
}