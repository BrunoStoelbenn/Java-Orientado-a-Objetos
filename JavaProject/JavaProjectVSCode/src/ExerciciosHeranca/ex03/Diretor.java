package ex03;

public class Diretor extends Funcionario{
    public Diretor(){
        super();
    }
        
    public Diretor(String _nome, String _cpf,double _salario){
        super(_nome, _cpf, _salario);
    }

    @Override
    public double getBonificacao(){
       return super.getBonificacao() + 2000;
    }
}
