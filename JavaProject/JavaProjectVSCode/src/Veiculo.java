import java.util.Scanner;
public class Veiculo implements Comparable<Veiculo>{
    Scanner input = new Scanner(System.in);
    String placa;
    String modelo;
    String fabricante;
    int km;
    int anofab;

    void def_dados(String placa, String modelo, String fabricante, int km, int anofab){
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
        while (anofab > 2024 || anofab < 1950){
            System.out.println("O ano de fabricação do veículo deve estar entre 1950 e 2024. Por favor, informe um ano de fabricação apropriado: ");
            anofab = input.nextInt();
        }
        this.anofab = anofab;
        while (km < 0){
            System.out.println("Não existe carro com quilometragem negativa. por favor, informe a quilometragem maior ou igual a 0: ");
            km = input.nextInt();
        }
        this.km = km;
    }
    void mostrar_dados(){
        System.out.println("O carro é da marca " + fabricante +", modelo "
         + modelo + ", com a placa " + placa + ". O carro é do ano "+ anofab +" e possui " + km + "km rodados." );
    }

    void aumentar_km(int kmParaAumentar){
        km += kmParaAumentar;
    }

    int ret_km(){
        return this.km;
    }

    int ret_ano(){
        return this.anofab;
    }

    public int compareTo(Veiculo veiculo) {
        if(this.km > veiculo.km){
        return 1;
        }
        else if(this.km < veiculo.km){
        return -1;
        }
        return 0;
        }
}

