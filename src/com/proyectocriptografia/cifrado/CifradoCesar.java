package com.proyectocriptografia.cifrado;

/**
 * Clase para el cifrado y descifrado utilizando el algoritmo César.
 */
public class CifradoCesar {

    private static final String ABECEDARIO = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ";

    /**
     * Cifra un texto utilizando el cifrado César.
     *
     * @param texto El texto a cifrar.
     * @param clave El número de posiciones a desplazar (clave).
     * @return El texto cifrado.
     */
    public String cifrar(String texto, int clave) {
        StringBuilder resultado = new StringBuilder();
        texto = texto.toUpperCase();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            int posicion = ABECEDARIO.indexOf(caracter);

            if (posicion != -1) {
                // Aplicamos la fórmula de cifrado: C = M + N mod 27
                int nuevaPosicion = (posicion + clave) % 27;
                if (nuevaPosicion < 0) {
                    nuevaPosicion += 27;
                }
                resultado.append(ABECEDARIO.charAt(nuevaPosicion));
            } else {
                // Si el carácter no está en el abecedario, lo dejamos igual
                resultado.append(caracter);
            }
        }
        return resultado.toString();
    }

    /**
     * Descifra un texto cifrado con el cifrado César.
     *
     * @param texto El texto cifrado.
     * @param clave La clave utilizada para cifrar.
     * @return El texto descifrado.
     */
    public String descifrar(String texto, int clave) {
        StringBuilder resultado = new StringBuilder();
        texto = texto.toUpperCase();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            int posicion = ABECEDARIO.indexOf(caracter);

            if (posicion != -1) {
                // Aplicamos la fórmula de descifrado: C = M - N mod 27
                int nuevaPosicion = (posicion - clave) % 27;
                if (nuevaPosicion < 0) {
                    nuevaPosicion += 27;
                }
                resultado.append(ABECEDARIO.charAt(nuevaPosicion));
            } else {
                // Si el carácter no está en el abecedario, lo dejamos igual
                resultado.append(caracter);
            }
        }
        return resultado.toString();
    }
}
