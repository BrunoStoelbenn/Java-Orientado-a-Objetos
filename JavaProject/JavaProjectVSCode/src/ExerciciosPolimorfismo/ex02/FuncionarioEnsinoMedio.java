package ExerciciosPolimorfismo.ex02;

public class FuncionarioEnsinoMedio extends Funcionario{
    private String escola;

    public FuncionarioEnsinoMedio(String nome, int codigoFuncional, String escola) {
        super(nome, codigoFuncional);
        this.escola = escola;
    }

    //  Método calcularRenda() que aumenta a renda básica em 50%
    @Override
    public double calcularRenda() {
        return super.calcularRenda() * 1.5;
    }

    @Override
    public String toString() {
        return super.toString() + ", Escola: " + escola;
    }
}
