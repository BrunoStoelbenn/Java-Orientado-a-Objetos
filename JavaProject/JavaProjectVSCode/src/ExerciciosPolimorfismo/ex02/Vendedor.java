package ExerciciosPolimorfismo.ex02;

public class Vendedor extends ComissaoDecorator{
    public Vendedor(Funcionario funcionario) {
        super(funcionario);
    }

    //  Método calcularRenda() que aumenta a renda total do funcionário em 850 porque ele é um vendedor.
    @Override
    public double calcularRenda() {
        return funcionario.calcularRenda() + 850;
    }

    @Override
    public String toString() {
        return funcionario.toString() + ", Comissão: 850.0";
    }
}
