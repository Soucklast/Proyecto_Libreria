/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Contraseña extends JPanel {
    private JPasswordField pwdCelda;
    private JLabel visibilidadLabel;
    private boolean pwdVisible;
    private ImageIcon mostrar, ocultar;

    public Contraseña() {
        // Configuración del panel
        setLayout(new FlowLayout());
        setOpaque(false);
        // Cargar las imágenes
        mostrar = new ImageIcon(getClass().getResource("/imagenes/Mostrar.png")); // Ruta de la imagen "mostrar"
        ocultar = new ImageIcon(getClass().getResource("/imagenes/Ocultar.png")); // Ruta de la imagen "ocultar"

        // Crear el campo de contraseña
        pwdCelda = new JPasswordField(15);
        pwdCelda.setEchoChar('*'); // Oculta el texto con asteriscos
        
        
        add(pwdCelda);

        // Crear la etiqueta para alternar visibilidad con el ícono de mostrar
        visibilidadLabel = new JLabel(mostrar);
        visibilidadLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        visibilidadLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePasswordVisibility();
            }
        });
        add(visibilidadLabel);

        
    }

    // Método para alternar la visibilidad de la contraseña
    private void togglePasswordVisibility() {
        if (pwdVisible) {
            pwdCelda.setEchoChar('*');
            visibilidadLabel.setIcon(mostrar); // Cambia a ícono de "mostrar"
        } else {
            pwdCelda.setEchoChar((char) 0); // Muestra el texto
            visibilidadLabel.setIcon(ocultar); // Cambia a ícono de "ocultar"
        }
        pwdVisible = !pwdVisible;
    }
    
    // Método para adquirir el texto de la celda
    public String getPasswordText() {
        return new String(pwdCelda.getPassword());
    }
    
    // Método para establecer el texto de la celda
    public void setPasswordText(String pwd) {
        pwdCelda.setText(pwd); // Establece el texto en la celda de la contraseña
    }

    public static void main(String[] args) {
        // Crear el JFrame
        JFrame frame = new JFrame("Panel de Contraseña");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        
        // Crear una instancia del panel de contraseña
        Contraseña contrasenaPanel = new Contraseña();
        
        // Agregar el panel al frame
        frame.add(contrasenaPanel);
        
        // Centrar la ventana y hacerla visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
