package ExerciciosPolimorfismo.ex02;

//  Classe abstrata que não deve ser instanciada diretamente e que deve servir de esqueleto para as classes filhas(Gerente, Supervisor e Vendedor)
public abstract class ComissaoDecorator extends Funcionario {
    protected Funcionario funcionario;

    public ComissaoDecorator(Funcionario funcionario) {
        super(funcionario.getNome(), funcionario.getCodigoFuncional()); // Valores fictícios
        this.funcionario = funcionario;
    }

    @Override
    public abstract double calcularRenda();

}
