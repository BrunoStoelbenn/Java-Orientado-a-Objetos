package ex03;

public class Secretaria extends Funcionario{
    public Secretaria(){
        super();
    }
        
    public Secretaria(String _nome, String _cpf,double _salario){
        super(_nome, _cpf, _salario);
    }

    @Override
    public double getBonificacao(){
       return super.getBonificacao() + 100;
    }

}