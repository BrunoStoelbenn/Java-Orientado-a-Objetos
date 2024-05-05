package ex03;

public class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;
    
    public Funcionario(){
    
    }
        
    public Funcionario(String _nome, String _cpf, double _salario){
        this.nome = _nome;
        this.cpf = _cpf;
        this.salario = _salario;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String _nome){
        this.nome = _nome;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String _cpf){
        this.cpf = _cpf;
    }

    public double getSalario(){
        return salario;
    }
    
    public void setCpf(double _salario){
        this.salario = _salario;
    }

    public double getBonificacao(){
        return salario * 0.2;
    }

    @Override
    public String toString(){
        return "O funcionário " + nome + ", com o número do cpf " + cpf + " recebe o salário de R$" + salario;
    } 
    
        
    }

