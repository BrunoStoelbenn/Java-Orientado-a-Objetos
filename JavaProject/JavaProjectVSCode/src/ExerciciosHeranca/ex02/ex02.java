package ex02;
// Enum para representar as localizações do ingresso VIP

import java.util.Arrays;
import java.util.Scanner;

enum Localizacao {
    CAMAROTE_SUPERIOR,
    CAMAROTE_INFERIOR
}

// Classe Ingresso
class Ingresso {
    protected double valor;

    public Ingresso(double valor) {
        this.valor = valor;
    }

    public double retornaValor() {
        return valor;
    }
}

// Classe IngressoNormal, que herda de Ingresso
class IngressoNormal extends Ingresso {
    public IngressoNormal(double valor) {
        super(valor);
    }

    @Override
    public String toString() {
        return "Ingresso Normal - Valor: R$" + valor;
    }
}

// Classe IngressoVip, que herda de Ingresso
class IngressoVip extends Ingresso {
    private Localizacao localizacao;
    private Scanner input = new Scanner(System.in);
    public IngressoVip(double valor, Localizacao localizacao) {
        super(valor);
        do {
            System.out.println("Escolha a localização:");
            System.out.println(Arrays.toString(Localizacao.values()));
            String localizacaoStr = input.next();
            try {
                localizacao= Localizacao.valueOf(localizacaoStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Localização inválida. Escolha uma localização da lista.");
                localizacao = null;
            }
        } while (localizacao == null);
        this.localizacao = localizacao;
    }

    public double retornaValorVip() {
        if (localizacao == Localizacao.CAMAROTE_SUPERIOR) {
            return valor * 1.5; // Adicional de 50%
        } else {
            return valor * 1.7; // Adicional de 70%
        }
    }

    @Override
    public String toString() {
        return "Ingresso VIP - Localização: " + localizacao + ", Valor: R$" + retornaValorVip();
    }
}

public class ex02 {
    public static void main(String[] args) {
        // Exemplo de uso das classes
        IngressoNormal ingressoNormal = new IngressoNormal(100.0);
        System.out.println(ingressoNormal); // Saída: Ingresso Normal - Valor: R$100.0

        IngressoVip ingressoVip1 = new IngressoVip(150.0, Localizacao.CAMAROTE_SUPERIOR);
        System.out.println(ingressoVip1); // Saída: Ingresso VIP - Localização: CAMAROTE_SUPERIOR, Valor: R$225.0

        IngressoVip ingressoVip2 = new IngressoVip(200.0, Localizacao.CAMAROTE_INFERIOR);
        System.out.println(ingressoVip2); // Saída: Ingresso VIP - Localização: CAMAROTE_INFERIOR, Valor: R$340.0
    }
}
