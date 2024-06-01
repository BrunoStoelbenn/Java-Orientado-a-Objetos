package ExerciciosPolimorfismo.ex02;

public class Supervisor extends ComissaoDecorator{
    public Supervisor(Funcionario funcionario) {
        super(funcionario);
    }

    //  Método calcularRenda() que aumenta a renda total do funcionário em 1800 porque ele é um supervisor.
    @Override
    public double calcularRenda() {
        return funcionario.calcularRenda() + 1800;
    }

    @Override
    public String toString() {
        return funcionario.toString() + ", Comissão: 1800.0";
    }
}
