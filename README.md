
# Proyecto de Criptografía Clásica

Este proyecto implementa varios algoritmos de cifrado clásico y métodos para atacarlos. A continuación, te explicamos cada componente de este proyecto, junto con ejemplos de uso para que cualquier persona pueda entender y aplicar estos conceptos.

## Contenido

1. **Cifrado César**  
2. **Ataque Fuerza Bruta al Cifrado César**  
3. **Cifrado Vigenère**  
4. **Ataque al Cifrado Vigenère mediante Análisis de Frecuencias**  
5. **Análisis de Frecuencias de Letras**

---

## 1. Cifrado César

### Descripción:
El **Cifrado César** es un método de cifrado por sustitución en el que cada letra del texto original se desplaza un número fijo de posiciones en el alfabeto. Este proyecto implementa un cifrado y descifrado basado en este algoritmo.

### Uso:
- Método `cifrar(texto, clave)`:
  - **Parámetros**:
    - `texto`: el texto que deseas cifrar.
    - `clave`: el número de posiciones a desplazar las letras en el alfabeto.
  - **Retorno**: El texto cifrado.

- Método `descifrar(texto, clave)`:
  - **Parámetros**:
    - `texto`: el texto que deseas descifrar.
    - `clave`: la clave que fue utilizada para cifrar el texto.
  - **Retorno**: El texto descifrado.

### Ejemplo:
```java
CifradoCesar cesar = new CifradoCesar();
String textoOriginal = "Hola Mundo";
int claveCesar = 3;
String textoCifrado = cesar.cifrar(textoOriginal, claveCesar);
System.out.println(textoCifrado);
```

---

## 2. Ataque Fuerza Bruta al Cifrado César

### Descripción:
El ataque por **fuerza bruta** al Cifrado César intenta descifrar el texto probando todas las claves posibles. El método prueba todas las claves del 1 al 25 (ya que el alfabeto tiene 26 letras) para encontrar el texto original.

### Uso:
- Método `ataqueFuerzaBruta(texto)`:
  - **Parámetros**:
    - `texto`: el texto cifrado que deseas descifrar.
  - **Retorno**: Una lista de todos los posibles descifrados.

### Ejemplo:
```java
AtaqueCesar ataque = new AtaqueCesar();
List<String> posiblesDescifrados = ataque.ataqueFuerzaBruta(textoCifrado);
```

---

## 3. Cifrado Vigenère

### Descripción:
El **Cifrado Vigenère** es una técnica de cifrado polialfabética que utiliza una clave para cifrar el texto. Cada letra del texto se desplaza de acuerdo con la letra correspondiente en la clave.

### Uso:
- Método `cifrar(texto, clave)`:
  - **Parámetros**:
    - `texto`: el texto que deseas cifrar.
    - `clave`: la clave utilizada para cifrar el texto.
  - **Retorno**: El texto cifrado.

- Método `descifrar(texto, clave)`:
  - **Parámetros**:
    - `texto`: el texto cifrado que deseas descifrar.
    - `clave`: la clave utilizada para cifrar el texto.
  - **Retorno**: El texto descifrado.

### Ejemplo:
```java
CifradoVigenere vigenere = new CifradoVigenere();
String clave = "CLAVE";
String textoCifrado = vigenere.cifrar(textoOriginal, clave);
System.out.println(textoCifrado);
```

---

## 4. Ataque al Cifrado Vigenère mediante Análisis de Frecuencias

### Descripción:
Este ataque utiliza el **análisis de frecuencias** para deducir la longitud de la clave y luego determinar la clave misma. Se basa en el hecho de que en un idioma, ciertas letras aparecen con mayor frecuencia, lo que ayuda a deducir las letras de la clave.

### Uso:
- Método `ataquePorFrecuencias(texto)`:
  - **Parámetros**:
    - `texto`: el texto cifrado con el cifrado Vigenère.
  - **Retorno**: El texto descifrado.

### Ejemplo:
```java
AtaqueVigenere ataqueVigenere = new AtaqueVigenere();
String textoDescifrado = ataqueVigenere.ataquePorFrecuencias(textoCifradoVigenere);
System.out.println(textoDescifrado);
```

---

## 5. Análisis de Frecuencias de Letras

### Descripción:
El **análisis de frecuencias** cuenta cuántas veces aparece cada letra en un texto dado, lo cual es útil para realizar ataques a cifrados como el de César o Vigenère.

### Uso:
- Método `analizarFrecuencias(texto)`:
  - **Parámetros**:
    - `texto`: el texto que deseas analizar.
  - **Retorno**: Un mapa con la frecuencia absoluta de cada letra.

- Método `calcularFrecuenciasRelativas(texto)`:
  - **Parámetros**:
    - `texto`: el texto que deseas analizar.
  - **Retorno**: Un mapa con la frecuencia relativa (en porcentaje) de cada letra.

### Ejemplo:
```java
AnalisisFrecuencias analisis = new AnalisisFrecuencias();
Map<Character, Integer> frecuencias = analisis.analizarFrecuencias(textoCifradoVigenere);
frecuencias.forEach((k, v) -> System.out.println(k + ": " + v));
```

---

## Ejemplo de Uso Completo:

```java
public class Main {
    public static void main(String[] args) {
        // Cifrado César
        CifradoCesar cesar = new CifradoCesar();
        String textoOriginal = "Hola Mundo";
        int claveCesar = 3;
        String textoCifradoCesar = cesar.cifrar(textoOriginal, claveCesar);
        System.out.println("Texto Cifrado César: " + textoCifradoCesar);
        System.out.println("Texto Descifrado César: " + cesar.descifrar(textoCifradoCesar, claveCesar));

        // Ataque por Fuerza Bruta al Cifrado César
        AtaqueCesar ataqueCesar = new AtaqueCesar();
        List<String> posiblesDescifrados = ataqueCesar.ataqueFuerzaBruta(textoCifradoCesar);
        System.out.println("Posibles Descifrados César:");
        posiblesDescifrados.forEach(System.out::println);

        // Cifrado Vigenère
        CifradoVigenere vigenere = new CifradoVigenere();
        String claveVigenere = "CLAVE";
        String textoCifradoVigenere = vigenere.cifrar(textoOriginal, claveVigenere);
        System.out.println("Texto Cifrado Vigenère: " + textoCifradoVigenere);
        System.out.println("Texto Descifrado Vigenère: " + vigenere.descifrar(textoCifradoVigenere, claveVigenere));

        // Análisis de Frecuencias
        AnalisisFrecuencias analisisFrecuencias = new AnalisisFrecuencias();
        Map<Character, Integer> frecuencias = analisisFrecuencias.analizarFrecuencias(textoCifradoVigenere);
        System.out.println("Frecuencias de Letras en el Texto Cifrado Vigenère:");
        frecuencias.forEach((k, v) -> System.out.println(k + ": " + v));

        // Ataque al Cifrado Vigenère
        AtaqueVigenere ataqueVigenere = new AtaqueVigenere();
        String textoDescifradoAtaque = ataqueVigenere.ataquePorFrecuencias(textoCifradoVigenere);
        System.out.println("Texto Descifrado por Ataque Vigenère: " + textoDescifradoAtaque);
    }
}
```

---

### Consideraciones:

- Los ataques de análisis de frecuencias asumen que el texto cifrado está en español. Si está en otro idioma, deberás ajustar las frecuencias de las letras más comunes.
- Los métodos ignoran caracteres especiales y acentos, enfocándose solo en letras del alfabeto.
