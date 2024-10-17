package com.proyectocriptografia.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase para realizar análisis de frecuencias de letras en un texto.
 */
public class AnalisisFrecuencias {

    /**
     * Realiza un análisis de frecuencias de las letras en un texto.
     *
     * @param texto El texto a analizar.
     * @return Un mapa con cada letra y su frecuencia absoluta.
     */
    public Map<Character, Integer> analizarFrecuencias(String texto) {
        Map<Character, Integer> frecuencias = new HashMap<>();

        for (char c : texto.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                frecuencias.put(c, frecuencias.getOrDefault(c, 0) + 1);
            }
        }
        return frecuencias;
    }

    /**
     * Calcula las frecuencias relativas de las letras en un texto.
     *
     * @param texto El texto a analizar.
     * @return Un mapa con cada letra y su frecuencia relativa.
     */
    public Map<Character, Double> calcularFrecuenciasRelativas(String texto) {
        Map<Character, Integer> frecuenciasAbsolutas = analizarFrecuencias(texto);
        Map<Character, Double> frecuenciasRelativas = new HashMap<>();
        int totalLetras = frecuenciasAbsolutas.values().stream().mapToInt(Integer::intValue).sum();

        for (Map.Entry<Character, Integer> entry : frecuenciasAbsolutas.entrySet()) {
            frecuenciasRelativas.put(entry.getKey(), (double) entry.getValue() / totalLetras);
        }
        return frecuenciasRelativas;
    }
}
