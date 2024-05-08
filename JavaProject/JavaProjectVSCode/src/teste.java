import javax.swing.*;
import java.awt.*;
import java.io.*;

public class teste {

    public static void main(String[] args) {
        // Criando o JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Exibição de Imagem");

        // Carregando a imagem
        ImageIcon icon = new ImageIcon("ExerciciosHeranca/ex04/Cachorro.jpg"); // Substitua "cachorro.jpg" pelo nome do seu arquivo de imagem
        JLabel label = new JLabel();
        label.setIcon(icon);

        // Adicionando a imagem ao JFrame
        frame.getContentPane().add(label, BorderLayout.CENTER);

        // Ajustando o tamanho do JFrame
        frame.pack();

        // Centralizando o JFrame na tela
        frame.setLocationRelativeTo(null);

        // Tornando o JFrame visível
        frame.setVisible(true);
    }
}