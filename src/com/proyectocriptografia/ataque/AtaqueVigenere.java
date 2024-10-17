package com.proyectocriptografia.ataque;

import com.proyectocriptografia.cifrado.CifradoVigenere;
import com.proyectocriptografia.util.AnalisisFrecuencias;
import java.util.Map;

/**
 * Clase para realizar ataques al cifrado Vigenère utilizando análisis de frecuencias.
 */
public class AtaqueVigenere {

    /**
     * Realiza un ataque basado en análisis de frecuencias para descifrar un texto cifrado con Vigenère.
     *
     * @param texto El texto cifrado.
     * @return El texto descifrado.
     */
    public String ataquePorFrecuencias(String texto) {
        int longitudClave = estimarLongitudClave(texto);
        String clave = deducirClave(texto, longitudClave);
        CifradoVigenere vigenere = new CifradoVigenere();
        return vigenere.descifrar(texto, clave);
    }

    /**
     * Estima la longitud de la clave utilizando el Índice de Coincidencia.
     *
     * @param texto El texto cifrado.
     * @return La longitud estimada de la clave.
     */
    private int estimarLongitudClave(String texto) {
        // Implementación simplificada: Asumimos que la longitud es 3
        return 3;
    }

    /**
     * Deduce la clave realizando análisis de frecuencias en el texto cifrado.
     *
     * @param texto          El texto cifrado.
     * @param longitudClave La longitud estimada de la clave.
     * @return La clave deducida.
     */
    private String deducirClave(String texto, int longitudClave) {
        StringBuilder clave = new StringBuilder();

        for (int i = 0; i < longitudClave; i++) {
            StringBuilder subTexto = new StringBuilder();

            for (int j = i; j < texto.length(); j += longitudClave) {
                char c = texto.charAt(j);
                if (Character.isLetter(c)) {
                    subTexto.append(c);
                }
            }
            char letraClave = deducirLetraClave(subTexto.toString());
            clave.append(letraClave);
        }
        return clave.toString();
    }

    /**
     * Deduce una letra de la clave analizando las frecuencias en un subtexto.
     *
     * @param subTexto El subtexto correspondiente a una posición de la clave.
     * @return La letra deducida de la clave.
     */
    private char deducirLetraClave(String subTexto) {
        AnalisisFrecuencias analisis = new AnalisisFrecuencias();
        Map<Character, Double> frecuencias = analisis.calcularFrecuenciasRelativas(subTexto);

        // Supongamos que la letra más común en español es 'E'
        char letraMasComun = 'E';
        char letraTextoMasComun = obtenerLetraMasFrecuente(frecuencias);

        int desplazamiento = (letraTextoMasComun - letraMasComun + 26) % 26;
        char letraClave = (char) ('A' + desplazamiento);
        return letraClave;
    }

    /**
     * Obtiene la letra más frecuente en el mapa de frecuencias.
     *
     * @param frecuencias Mapa de frecuencias de letras.
     * @return La letra más frecuente.
     */
    private char obtenerLetraMasFrecuente(Map<Character, Double> frecuencias) {
        char letraMasFrecuente = 'A';
        double maxFrecuencia = 0.0;

        for (Map.Entry<Character, Double> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                letraMasFrecuente = entry.getKey();
            }
        }
        return letraMasFrecuente;
    }
}
