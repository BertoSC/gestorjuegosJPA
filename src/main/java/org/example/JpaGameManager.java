package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JpaGameManager {
    public static final String GAME_H2 = "gestorjuegosH2";

    public static final Map<String, EntityManagerFactory> instancias = new HashMap<>();

    private static boolean isEntityManagerFactoryClosed (String unidadPers){
        return !instancias.containsKey(unidadPers) || instancias.get(unidadPers)==null ||
                !instancias.get(unidadPers).isOpen();
    }

    public static EntityManagerFactory getEntityManagerFactory(String unidadPers){
        if (isEntityManagerFactoryClosed(unidadPers)){
            synchronized (JpaGameManager.class){
                if (isEntityManagerFactoryClosed(unidadPers)){
                    instancias.put(unidadPers, Persistence.createEntityManagerFactory(unidadPers));
                }
            }
        }
        return instancias.get(unidadPers);
    }

    public static EntityManager getEntityManager (String unidadPers){
        return getEntityManagerFactory(unidadPers).createEntityManager();
    }

    public static void close (String unidadPers){
        if (instancias.containsKey(unidadPers)){
            instancias.get(unidadPers).close();
            instancias.remove(unidadPers);
        }

    }


}
