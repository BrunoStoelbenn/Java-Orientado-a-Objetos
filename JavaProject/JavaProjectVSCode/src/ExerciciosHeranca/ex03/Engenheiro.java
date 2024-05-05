package ex03;

public class Engenheiro extends Funcionario{
    public Engenheiro(){
        super();
    }
        
    public Engenheiro(String _nome, String _cpf,double _salario){
        super(_nome, _cpf, _salario);
    }

    @Override
    public double getBonificacao(){
        return super.getBonificacao() + 550;
    }
}
