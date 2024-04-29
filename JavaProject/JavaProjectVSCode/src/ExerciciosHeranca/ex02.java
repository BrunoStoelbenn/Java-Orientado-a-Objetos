package ExerciciosHeranca;

import java.util.Scanner;

public class ex02 {
    
    enum Localizacao{
        CAMAROTE_SUPERIOR, CAMAROTE_INFERIOR
    }

    public class Ingresso{
        private double valor;
        
        public Ingresso(double _valor){
            this.valor = _valor;
        }

        public double retornaValor(){
            return valor;
        }

    }

    public class IngressoNormal extends Ingresso{
        public IngressoNormal(double _valor){
            super(_valor);
        }

        public String toString(){
            return ""
        }

    }

    public class IngressoVip extends Ingresso{
        Scanner input = new Scanner(System.in);
        private Localizacao camarote;
        public IngressoVip(double _valor, Localizacao _camarote){
            super(_valor);
            while (_camarote.toUpperCase() != "CAMAROTE_SUPERIOR" || _camarote.toUpperCase() != "CAMAROTE_INFERIOR") {
                System.out.println("Por favor, escolha camarote_superior ou camarote_inferior");
                String camaroteCorrecao = input.next();
                _camarote = camaroteCorrecao;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
