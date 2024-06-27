
package com.mycompany.heladeria;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Entrada extends JWindow{
    private int duration;

    public Entrada(int d) {
        duration = d;
    }

    public void showSplash() {
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);
        
        // Obtener la ruta absoluta del proyecto
        String projectPath = System.getProperty("user.dir");
        
        // Construir la ruta de la imagen
        String imagePath = projectPath + File.separator + "imagenes" + File.separator + "Hela.jpg";// Cambiar el nombre de la imagen y la extension
        
        // Cargar la imagen del logo y reducir su tamaño
        Image logoImage = null;
        try {
            logoImage = ImageIO.read(new File(imagePath)).getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Configurar la posición y tamaño del splash screen
        int width = 300;
        int height = 300;
        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);
        
        // Construir el splash screen
        JLabel label = new JLabel(new ImageIcon(logoImage));
        content.add(label, BorderLayout.CENTER);
        
        JLabel copyrt = new JLabel("© 2024 Intento de una heladeria sin bases", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(copyrt, BorderLayout.SOUTH);
        
        /*JLabel imgpath = new JLabel(imagePath, JLabel.CENTER);
        content.add(imgpath, BorderLayout.SOUTH);*/
        
        // Mostrar el splash screen
        setVisible(true);
        
        // Esperar el tiempo especificado antes de cerrar el splash screen
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            // Manejar la interrupción del hilo
        }
        
        // Cerrar el splash screen
        setVisible(false);
    }
}

