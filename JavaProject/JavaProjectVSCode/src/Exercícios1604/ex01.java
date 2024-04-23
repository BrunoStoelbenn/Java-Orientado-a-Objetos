import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ex01 {
    public static void main(String[] args) {
        ArrayList<Integer> numerosMultiplados = new ArrayList<Integer>();
        int numeros[][] = new int[4][5];
        Random random = new Random();
        preencherArray(numeros, random);
        imprimirArray(numeros);
        int maiorValor = encontrarMaiorValorArray(numeros);
        arrayNumerosMultiplicados(numeros, numerosMultiplados, maiorValor);
        imprimirArrayList(numerosMultiplados);
        System.out.println();
    }

    public static void preencherArray(int array[][], Random random){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = random.nextInt(100);
            }
        }
    }

    public static void imprimirArray(int array[][]){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int encontrarMaiorValorArray(int array[][]){
        int maiorValor = array[0][0];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if (array[i][j] > maiorValor){
                    maiorValor = array[i][j];
                }
            }
        }
    return maiorValor;
    }

    public static void arrayNumerosMultiplicados(int array[][], ArrayList<Integer> numerosMultiplados, int maiorValorEncontradoListaBidimensional){
        int numeroMultiplicado;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                numeroMultiplicado = array[i][j] * maiorValorEncontradoListaBidimensional;
                numerosMultiplados.add(numeroMultiplicado);
            }
        }
    }

    public static void imprimirArrayList(ArrayList<Integer> numeros){
        Collections.sort(numeros);
        int i = 0;
        System.out.println();
        System.out.println("ArrayList de números já multiplicados pelo maior número da array bidimensional anterior e ordenada");
        for (int numero : numeros){
            if (i > 4){
                System.out.println();
                System.out.print(numero + " ");
                i = 0;
                i++;
            }
            else{
                System.out.print(numero + " ");
                i++;
            }
            
        }
    }
}
