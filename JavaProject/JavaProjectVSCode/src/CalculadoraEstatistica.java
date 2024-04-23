import java.util.Scanner;
public class CalculadoraEstatistica {
    float[] vetor;
    int n;


    void preencherVetor(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o tamanho do vetor: ");
        n = input.nextInt();
        vetor = new float[n];
        for(int i=0; i<n; i++){
            
            System.out.println("Digite o " + (i+1) + " valor do vetor: ");
            vetor[i] = input.nextFloat();
        }
        input.close();
    }

    void mostrarVetor(){
        System.out.println();
        for(int i=0; i<n; i++){
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    void maiorValor(){
        float maior = vetor[0];
        for(int i=0; i<n; i++){
            if (vetor[i] > maior){
                maior = vetor[i];
            }
            else{
                continue;
            }
        }
        System.out.println("O maior valor é o "+ maior + "!");
    }
    void menorValor(){
        float menor = vetor[0];
        for(int i=0; i<n; i++){
            if (vetor[i] < menor){
                menor = vetor[i];
            }
            else{
                continue;
            }
        }
        System.out.println("O menor valor é o "+ menor + "!");
    }
    void media(){
        float somatorio = 0;
        for(int i=0; i<n; i++){
                somatorio += vetor[i];
            }
            float media = (float)somatorio / n;
        System.out.println("A média é "+ media + "!");
        }

    void somatorio(){
        float somatorio = 0;
        for(int i=0; i<n; i++){
                somatorio += vetor[i];
            }
        System.out.println("o somatorio de todos os valores do vetor é "+ somatorio + "!");
        }
}

