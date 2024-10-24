package criptografia_clasica;

import com.proyectocriptografia.cifrado.CifradoCesar;
import com.proyectocriptografia.cifrado.CifradoVigenere;
import com.proyectocriptografia.ataque.AtaqueCesar;
import com.proyectocriptografia.ataque.AtaqueVigenere;
import com.proyectocriptografia.util.AnalisisFrecuencias;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Criptografia_Clasica {

    private JFrame frame;
    private JTextField textoOriginalField;
    private JTextField claveCesarField;
    private JTextField claveVigenereField;
    private JTextArea outputArea;
    private String textoCifradoVigenere;  // Almacena el texto cifrado Vigenère

    public Criptografia_Clasica() {
        // Crear el marco principal
        frame = new JFrame("Criptografía Clásica");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el panel principal
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Etiqueta y campo para el texto original
        JLabel textoOriginalLabel = new JLabel("Texto Original:");
        textoOriginalLabel.setBounds(10, 20, 100, 25);
        panel.add(textoOriginalLabel);

        textoOriginalField = new JTextField(20);
        textoOriginalField.setBounds(120, 20, 300, 25);
        panel.add(textoOriginalField);

        // Etiqueta y campo para la clave del Cifrado César
        JLabel claveCesarLabel = new JLabel("Clave César:");
        claveCesarLabel.setBounds(10, 60, 100, 25);
        panel.add(claveCesarLabel);

        claveCesarField = new JTextField(20);
        claveCesarField.setBounds(120, 60, 150, 25);
        panel.add(claveCesarField);

        // Etiqueta y campo para la clave del Cifrado Vigenère
        JLabel claveVigenereLabel = new JLabel("Clave Vigenère:");
        claveVigenereLabel.setBounds(10, 100, 100, 25);
        panel.add(claveVigenereLabel);

        claveVigenereField = new JTextField(20);
        claveVigenereField.setBounds(120, 100, 150, 25);
        panel.add(claveVigenereField);

        // Botón para cifrar con César
        JButton cifrarCesarButton = new JButton("Cifrar César");
        cifrarCesarButton.setBounds(10, 140, 150, 25);
        panel.add(cifrarCesarButton);

        // Botón para cifrar con Vigenère
        JButton cifrarVigenereButton = new JButton("Cifrar Vigenère");
        cifrarVigenereButton.setBounds(170, 140, 150, 25);
        panel.add(cifrarVigenereButton);

        // Botón para realizar análisis de frecuencias
        JButton analisisFrecuenciaButton = new JButton("Análisis de Frecuencia");
        analisisFrecuenciaButton.setBounds(330, 140, 200, 25);
        panel.add(analisisFrecuenciaButton);

        // Botón para ataque de fuerza bruta en César
        JButton ataqueCesarButton = new JButton("Ataque César");
        ataqueCesarButton.setBounds(10, 180, 150, 25);
        panel.add(ataqueCesarButton);

        // Botón para ataque de Vigenère
        JButton ataqueVigenereButton = new JButton("Ataque Vigenère");
        ataqueVigenereButton.setBounds(170, 180, 150, 25);
        panel.add(ataqueVigenereButton);

        // Área de salida para mostrar resultados
        outputArea = new JTextArea();
        outputArea.setBounds(10, 220, 550, 200);
        panel.add(outputArea);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(10, 220, 550, 200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

        // Acción para el botón Cifrar César
        cifrarCesarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cifrarCesar();
            }
        });

        // Acción para el botón Cifrar Vigenère
        cifrarVigenereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cifrarVigenere();
            }
        });

        // Acción para el botón Análisis de Frecuencias
        analisisFrecuenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analisisFrecuencia();
            }
        });

        // Acción para el botón Ataque Fuerza Bruta César
        ataqueCesarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ataqueCesar();
            }
        });

        // Acción para el botón Ataque Vigenère
        ataqueVigenereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ataqueVigenere();
            }
        });
    }

    private void cifrarCesar() {
        String textoOriginal = textoOriginalField.getText();
        int claveCesar;
        try {
            claveCesar = Integer.parseInt(claveCesarField.getText());
        } catch (NumberFormatException e) {
            outputArea.setText("Por favor, introduce un número válido para la clave César.");
            return;
        }

        CifradoCesar cesar = new CifradoCesar();
        String textoCifrado = cesar.cifrar(textoOriginal, claveCesar);
        String textoDescifrado = cesar.descifrar(textoCifrado, claveCesar);

        outputArea.setText("Texto Cifrado César: " + textoCifrado + "\n");
        outputArea.append("Texto Descifrado César: " + textoDescifrado + "\n");
    }

    private void cifrarVigenere() {
        String textoOriginal = textoOriginalField.getText();
        String claveVigenere = claveVigenereField.getText();

        CifradoVigenere vigenere = new CifradoVigenere();
        textoCifradoVigenere = vigenere.cifrar(textoOriginal, claveVigenere);  // Guardar el texto cifrado
        String textoDescifrado = vigenere.descifrar(textoCifradoVigenere, claveVigenere);

        outputArea.setText("Texto Cifrado Vigenère: " + textoCifradoVigenere + "\n");
        outputArea.append("Texto Descifrado Vigenère: " + textoDescifrado + "\n");
    }

    private void analisisFrecuencia() {
        if (textoCifradoVigenere == null || textoCifradoVigenere.isEmpty()) {
            outputArea.setText("Primero debes cifrar el texto usando Vigenère.");
            return;
        }

        AnalisisFrecuencias analisisFrecuencias = new AnalisisFrecuencias();
        Map<Character, Integer> frecuencias = analisisFrecuencias.analizarFrecuencias(textoCifradoVigenere);

        outputArea.setText("Frecuencias de Letras en el Texto Cifrado Vigenère:\n");
        frecuencias.forEach((k, v) -> outputArea.append(k + ": " + v + "\n"));
    }

    private void ataqueCesar() {
        String textO = textoOriginalField.getText();
        CifradoCesar cesar = new CifradoCesar();
        int claveCesar = Integer.parseInt(claveCesarField.getText());
        String textoCifrado = cesar.cifrar(textO, claveCesar);

        AtaqueCesar ataqueCesar = new AtaqueCesar();
        List<String> posiblesDescifrados = ataqueCesar.ataqueFuerzaBruta(textoCifrado);

        outputArea.setText("Posibles Descifrados César (Ataque Fuerza Bruta):\n");
        posiblesDescifrados.forEach(posible -> outputArea.append(posible + "\n"));
    }

    private void ataqueVigenere() {
        if (textoCifradoVigenere == null || textoCifradoVigenere.isEmpty()) {
            outputArea.setText("Primero debes cifrar el texto usando Vigenère.");
            return;
        }

        AtaqueVigenere ataqueVigenere = new AtaqueVigenere();
        String textoDescifrado = ataqueVigenere.ataquePorFrecuencias(textoCifradoVigenere);

        outputArea.setText("Texto Descifrado por Ataque Vigenère: " + textoDescifrado + "\n");
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica
        new Criptografia_Clasica();
    }
}
