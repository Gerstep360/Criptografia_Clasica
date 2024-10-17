package com.proyectocriptografia.ataque;

import com.proyectocriptografia.cifrado.CifradoCesar;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para realizar ataques por fuerza bruta al cifrado César.
 */
public class AtaqueCesar {

    /**
     * Realiza un ataque por fuerza bruta al texto cifrado y devuelve una lista de posibles descifrados.
     *
     * @param texto El texto cifrado.
     * @return Una lista de posibles descifrados con sus claves correspondientes.
     */
    public List<String> ataqueFuerzaBruta(String texto) {
        List<String> posiblesDescifrados = new ArrayList<>();
        CifradoCesar cesar = new CifradoCesar();

        for (int clave = 1; clave < 26; clave++) {
            String descifrado = cesar.descifrar(texto, clave);
            posiblesDescifrados.add("Clave " + clave + ": " + descifrado);
        }
        return posiblesDescifrados;
    }
}
