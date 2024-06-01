package ExerciciosPolimorfismo.ex02;

public class Gerente extends ComissaoDecorator{
    public Gerente(Funcionario funcionario) {
        super(funcionario);
    }

    //  Método calcularRenda() que aumenta a renda total do funcionário em 5000 porque ele é um gerente.
    @Override
    public double calcularRenda() {
        return funcionario.calcularRenda() + 5000;
    }

    @Override
    public String toString() {
        return funcionario.toString() + ", Comissão: 5000.0";
    }
}
