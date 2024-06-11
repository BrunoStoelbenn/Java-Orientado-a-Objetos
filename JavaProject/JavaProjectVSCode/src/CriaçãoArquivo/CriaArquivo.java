package CriaçãoArquivo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CriaArquivo {
    public static void main(String[] args) {
        // Nome do arquivo a ser criado
        String nomeArquivo = "exemplo.txt";

        // Tenta criar e escrever no arquivo
        try {
            // Cria o objeto File
            File arquivo = new File(nomeArquivo);

            // Verifica se o arquivo já existe
            if (arquivo.exists()) {
                System.out.println("O arquivo já existe.");
            } else {
                // Cria um novo arquivo
                if (arquivo.createNewFile()) {
                    System.out.println("Arquivo criado: " + arquivo.getName());
                } else {
                    System.out.println("Falha ao criar o arquivo.");
                }
            }

            // Usa FileWriter para escrever no arquivo
            FileWriter escritor = new FileWriter(arquivo);
            escritor.write("Olá, mundo!\n");
            escritor.write("Este é um exemplo de escrita em arquivo em Java.\n");
            escritor.close(); // Fecha o escritor
            System.out.println("Dados gravados no arquivo.");

        } catch (IOException e) {
            // Trata exceções de IO
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }
}
