
import com.proyectocriptografia.cifrado.CifradoCesar;
import com.proyectocriptografia.cifrado.CifradoVigenere;
import com.proyectocriptografia.ataque.AtaqueCesar;
import com.proyectocriptografia.ataque.AtaqueVigenere;
import com.proyectocriptografia.util.AnalisisFrecuencias;
import java.util.List;
import java.util.Map;

/**
 *
 * @author German
 */
public class Criptografia_Clasica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // Ejemplo de Cifrado César
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

        // Ejemplo de Cifrado Vigenère
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
