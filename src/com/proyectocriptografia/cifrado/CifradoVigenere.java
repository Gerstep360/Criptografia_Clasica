package com.proyectocriptografia.cifrado;

/**
 * Clase para el cifrado y descifrado utilizando el algoritmo Vigenère.
 */
public class CifradoVigenere {

    private static final String ABECEDARIO = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

    /**
     * Cifra un texto utilizando el cifrado Vigenère.
     *
     * @param texto El texto a cifrar.
     * @param clave La clave de cifrado.
     * @return El texto cifrado.
     */
    public String cifrar(String texto, String clave) {
        StringBuilder resultado = new StringBuilder();
        texto = texto.toUpperCase();
        clave = clave.toUpperCase();
        int indiceClave = 0;

        for (int i = 0; i < texto.length(); i++) {
            char caracterTexto = texto.charAt(i);
            if (ABECEDARIO.indexOf(caracterTexto) != -1) {
                char caracterClave = clave.charAt(indiceClave % clave.length());
                int posicionTexto = ABECEDARIO.indexOf(caracterTexto);
                int posicionClave = ABECEDARIO.indexOf(caracterClave);

                // Aplicamos la fórmula: C = (M + K) mod 27
                int posicionCifrada = (posicionTexto + posicionClave) % 27;
                resultado.append(ABECEDARIO.charAt(posicionCifrada));

                indiceClave++;
            } else {
                // Si el carácter no está en el abecedario, lo dejamos igual
                resultado.append(caracterTexto);
            }
        }
        return resultado.toString();
    }

    /**
     * Descifra un texto cifrado con el cifrado Vigenère.
     *
     * @param texto El texto cifrado.
     * @param clave La clave utilizada para cifrar.
     * @return El texto descifrado.
     */
    public String descifrar(String texto, String clave) {
        StringBuilder resultado = new StringBuilder();
        texto = texto.toUpperCase();
        clave = clave.toUpperCase();
        int indiceClave = 0;

        for (int i = 0; i < texto.length(); i++) {
            char caracterTexto = texto.charAt(i);
            if (ABECEDARIO.indexOf(caracterTexto) != -1) {
                char caracterClave = clave.charAt(indiceClave % clave.length());
                int posicionTexto = ABECEDARIO.indexOf(caracterTexto);
                int posicionClave = ABECEDARIO.indexOf(caracterClave);

                // Aplicamos la fórmula: M = (C - K + 27) mod 27
                int posicionDescifrada = (posicionTexto - posicionClave + 27) % 27;
                resultado.append(ABECEDARIO.charAt(posicionDescifrada));

                indiceClave++;
            } else {
                // Si el carácter no está en el abecedario, lo dejamos igual
                resultado.append(caracterTexto);
            }
        }
        return resultado.toString();
    }
}
