package ExerciciosPolimorfismo.ex02;

public class Funcionario {
    private String nome;
    private int codigoFuncional;
    private double rendaBasica;

    public Funcionario(String nome, int codigoFuncional){
        this.nome = nome;
        this.codigoFuncional = codigoFuncional;
        this.rendaBasica = 1000.0;
    }

    public double calcularRenda(){
        return rendaBasica;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + ", Código Funcional: " + codigoFuncional + ", Salário: " + calcularRenda();  
    }

    public String getNome(){
        return nome;
    }

    public int getCodigoFuncional(){
        return codigoFuncional;
    }
    
}
