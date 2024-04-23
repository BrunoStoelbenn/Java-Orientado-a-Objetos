import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class veiculoMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int carrosParaAdicionar = 3;
        List<Veiculo> veiculos = new ArrayList<>();
        veiculoMain veiculoMain = new veiculoMain();
        veiculoMain.adicionarCarros(veiculos, input, carrosParaAdicionar);
        veiculoMain.retornarQuilometragem(veiculos);
    }

    public void adicionarCarros(List<Veiculo> veiculos, Scanner input, int carrosParaAdicionar){ //Função criada para adicionar os objetos da classe carro
        for(int i=0; i < carrosParaAdicionar; i++){
            System.out.println("Digite a placa do veículo " + (i+1) + ": ");
            String placa = input.next();
            input.nextLine(); // Limpar o buffer
            System.out.println("Digite o modelo do veículo " + (i+1) + ": ");
            String modelo = input.nextLine();
            System.out.println("Digite a fabricante do veículo " + (i+1) + ": ");
            String fabricante = input.next();
            System.out.println("Digite a kilometragem do veículo " + (i+1) + ": ");
            int kilometragem = input.nextInt();
            System.out.println("Digite o ano de fabricação do veículo " + (i+1) + ": ");
            int anofab = input.nextInt();
            Veiculo veiculo = new Veiculo();
            veiculo.def_dados(placa, modelo, fabricante, kilometragem, anofab);
            veiculos.add(veiculo);
           }
       
    }

    public void retornarQuilometragem(List<Veiculo> veiculos) {
        Collections.sort(veiculos);
    
        System.out.println("Veículos em ordem crescente de quilometragem:");
        for (Veiculo veiculo : veiculos) {
            veiculo.mostrar_dados();
        }
    
        // Encontrar o veículo com a menor quilometragem
        Veiculo menorQuilometragem = veiculos.get(0);
        for (Veiculo veiculo : veiculos) {
            if (veiculo.ret_km() < menorQuilometragem.ret_km()) {
                menorQuilometragem = veiculo;
            }
        }
        System.out.println();
        System.out.println("Veículo com menor quilometragem:");
        menorQuilometragem.mostrar_dados();
    }

}

