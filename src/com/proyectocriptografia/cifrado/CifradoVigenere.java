package com.proyectocriptografia.cifrado;

/**
 * Clase para el cifrado y descifrado utilizando el algoritmo Vigenère.
 */
public class CifradoVigenere {

    /**
     * Cifra un texto utilizando el cifrado Vigenère.
     *
     * @param texto El texto a cifrar.
     * @param clave La clave de cifrado.
     * @return El texto cifrado.
     */
    public String cifrar(String texto, String clave) {
        StringBuilder resultado = new StringBuilder();
        clave = clave.toUpperCase();
        int indiceClave = 0;

        for (char caracter : texto.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';
                int desplazamiento = clave.charAt(indiceClave % clave.length()) - 'A';
                int valorCaracter = (caracter - base + desplazamiento) % 26;
                resultado.append((char) (base + valorCaracter));
                indiceClave++;
            } else {
                resultado.append(caracter);
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
        clave = clave.toUpperCase();
        int indiceClave = 0;

        for (char caracter : texto.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';
                int desplazamiento = clave.charAt(indiceClave % clave.length()) - 'A';
                int valorCaracter = (caracter - base - desplazamiento + 26) % 26;
                resultado.append((char) (base + valorCaracter));
                indiceClave++;
            } else {
                resultado.append(caracter);
            }
        }
        return resultado.toString();
    }
}
