package com.proyectocriptografia.ataque;

import com.proyectocriptografia.cifrado.CifradoVigenere;
import java.util.*;

/**
 * Clase para realizar ataques al cifrado Vigenère utilizando fuerza bruta.
 */
public class AtaqueVigenere {

    private static final String ABECEDARIO = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

    /**
     * Realiza un ataque por fuerza bruta al texto cifrado y devuelve una lista de posibles descifrados.
     *
     * @param texto El texto cifrado.
     * @param maxKeyLength Longitud máxima de clave a probar.
     * @return Una lista de posibles descifrados con sus claves correspondientes.
     */
    public List<String> ataqueFuerzaBruta(String texto, int maxKeyLength) {
        List<String> posiblesDescifrados = new ArrayList<>();
        texto = texto.toUpperCase();
        texto = filtrarTexto(texto);
        CifradoVigenere vigenere = new CifradoVigenere();

        for (int keyLength = 1; keyLength <= maxKeyLength; keyLength++) {
            List<String> claves = generarClaves(keyLength);
            for (String clave : claves) {
                String descifrado = vigenere.descifrar(texto, clave);
                posiblesDescifrados.add("Clave: " + clave + " - Descifrado: " + descifrado);
            }
        }

        return posiblesDescifrados;
    }

    /**
     * Genera todas las posibles claves de una longitud dada utilizando el abecedario.
     *
     * @param length La longitud de la clave.
     * @return Una lista de claves.
     */
    private List<String> generarClaves(int length) {
        List<String> claves = new ArrayList<>();
        generarClavesRecursivo("", length, claves);
        return claves;
    }

    private void generarClavesRecursivo(String prefix, int length, List<String> claves) {
        if (length == 0) {
            claves.add(prefix);
            return;
        }

        for (int i = 0; i < ABECEDARIO.length(); i++) {
            generarClavesRecursivo(prefix + ABECEDARIO.charAt(i), length - 1, claves);
        }
    }

    /**
     * Filtra el texto para que solo contenga letras del abecedario definido.
     *
     * @param texto El texto a filtrar.
     * @return El texto filtrado.
     */
    private String filtrarTexto(String texto) {
        StringBuilder textoFiltrado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (ABECEDARIO.indexOf(c) != -1) {
                textoFiltrado.append(c);
            }
        }

        return textoFiltrado.toString();
    }
}
