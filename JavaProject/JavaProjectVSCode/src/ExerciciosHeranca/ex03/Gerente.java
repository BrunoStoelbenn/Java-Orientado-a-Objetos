package ex03;

public class Gerente extends Funcionario{
    public Gerente(){
        super();
    }
        
    public Gerente(String _nome, String _cpf,double _salario){
        super(_nome, _cpf, _salario);
    }

    @Override
    public double getBonificacao(){
        return super.getBonificacao() + 1000;
    }

}
