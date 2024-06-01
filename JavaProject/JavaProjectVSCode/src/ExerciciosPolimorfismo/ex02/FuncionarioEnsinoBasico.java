package ExerciciosPolimorfismo.ex02;

public class FuncionarioEnsinoBasico extends Funcionario{
    private String escola;

    public FuncionarioEnsinoBasico(String nome, int codigoFuncional, String escola) {
        super(nome, codigoFuncional);
        this.escola = escola;
    }

    //  Método calcularRenda() que aumenta a renda básica em 10%
    @Override
    public double calcularRenda() {
        return super.calcularRenda() * 1.1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Escola: " + escola;
    }
}
