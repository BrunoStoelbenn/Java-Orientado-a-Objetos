import java.util.Scanner;
public class ex01aula {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Pessoa pessoa_teste;
        pessoa_teste = new Pessoa();
        System.out.println("Digite o seu nome: ");
        String nome_pessoa = input.nextLineBr();
        System.out.println("Digite a sua idade: ");
        int idade_pessoa = input.nextInt();

        pessoa_teste.crianca_adolescente_adulto(idade_pessoa, nome_pessoa);
    
        input.close();
    }
}


    



