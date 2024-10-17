package com.proyectocriptografia.cifrado;

/**
 * Clase para el cifrado y descifrado utilizando el algoritmo César.
 */
public class CifradoCesar {

    /**
     * Cifra un texto utilizando el cifrado César.
     *
     * @param texto El texto a cifrar.
     * @param clave El número de posiciones a desplazar (clave).
     * @return El texto cifrado.
     */
    public String cifrar(String texto, int clave) {
        StringBuilder resultado = new StringBuilder();

        for (char caracter : texto.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';
                int desplazamiento = (caracter - base + clave) % 26;
                if (desplazamiento < 0) {
                    desplazamiento += 26;
                }
                resultado.append((char) (base + desplazamiento));
            } else {
                resultado.append(caracter); // No modifica caracteres no alfabéticos
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
        return cifrar(texto, -clave);
    }
}
