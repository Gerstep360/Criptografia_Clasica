package com.proyectocriptografia.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase para realizar análisis de frecuencias de letras en un texto y cifrarlo/descifrarlo.
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

    /**
     * Cifra un texto utilizando un mapeo basado en las frecuencias de las letras.
     *
     * @param textoClaro El texto original a cifrar.
     * @return El texto cifrado.
     */
    public String cifrarPorFrecuencias(String textoClaro) {
        // Frecuencias de letras en español ordenadas de mayor a menor frecuencia
        char[] letrasFrecuentesEsp = {'E', 'A', 'O', 'S', 'R', 'N', 'I', 'D', 'L', 'C', 'T', 'U',
                                      'M', 'P', 'B', 'G', 'V', 'Y', 'Q', 'H', 'F', 'Z', 'J', 'Ñ', 'X', 'K', 'W'};

        // Crear un mapeo de cifrado invirtiendo las frecuencias
        Map<Character, Character> mapeoCifrado = new HashMap<>();
        int n = letrasFrecuentesEsp.length;
        for (int i = 0; i < n; i++) {
            mapeoCifrado.put(letrasFrecuentesEsp[i], letrasFrecuentesEsp[n - i - 1]);
        }

        // Construir el texto cifrado
        StringBuilder textoCifrado = new StringBuilder();
        for (char c : textoClaro.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                char reemplazo = mapeoCifrado.getOrDefault(c, c);
                textoCifrado.append(reemplazo);
            } else {
                textoCifrado.append(c);
            }
        }

        return textoCifrado.toString();
    }

    /**
     * Descifra un texto cifrado utilizando análisis de frecuencias.
     *
     * @param textoCifrado El texto cifrado a descifrar.
     * @return El texto descifrado.
     */
    public String descifrarPorFrecuencias(String textoCifrado) {
        // Frecuencias de letras en español ordenadas de mayor a menor frecuencia
        char[] letrasFrecuentesEsp = {'E', 'A', 'O', 'S', 'R', 'N', 'I', 'D', 'L', 'C', 'T', 'U',
                                      'M', 'P', 'B', 'G', 'V', 'Y', 'Q', 'H', 'F', 'Z', 'J', 'Ñ', 'X', 'K', 'W'};

        // Analizar frecuencias en el texto cifrado
        Map<Character, Integer> frecuenciasCifrado = analizarFrecuencias(textoCifrado);

        // Ordenar las letras del texto cifrado por frecuencia (de mayor a menor)
        List<Map.Entry<Character, Integer>> letrasCifradoOrdenadas = new ArrayList<>(frecuenciasCifrado.entrySet());
        letrasCifradoOrdenadas.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Crear un mapeo de letras del cifrado a letras del español
        Map<Character, Character> mapeo = new HashMap<>();
        int limit = Math.min(letrasFrecuentesEsp.length, letrasCifradoOrdenadas.size());
        for (int i = 0; i < limit; i++) {
            mapeo.put(letrasCifradoOrdenadas.get(i).getKey(), letrasFrecuentesEsp[i]);
        }

        // Construir el texto descifrado
        StringBuilder textoDescifrado = new StringBuilder();
        for (char c : textoCifrado.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                char reemplazo = mapeo.getOrDefault(c, c);
                textoDescifrado.append(reemplazo);
            } else {
                textoDescifrado.append(c);
            }
        }

        return textoDescifrado.toString();
    }
}
