import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;

public class teste {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Exibição de Imagem");

        // Carregando a imagem
        File arquivo = new File("cachorro.jpg"); // Substitua "cachorro.jpg" pelo nome do seu arquivo de imagem
        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Criando um JLabel para exibir a imagem
        JLabel label = new JLabel(new ImageIcon(imagem));

        // Adicionando o JLabel ao JFrame
        frame.getContentPane().add(label, BorderLayout.CENTER);

        // Ajustando o tamanho do JFrame
        frame.pack();

        // Centralizando o JFrame na tela
        frame.setLocationRelativeTo(null);

        // Tornando o JFrame visível
        frame.setVisible(true);
        
        

    }
}