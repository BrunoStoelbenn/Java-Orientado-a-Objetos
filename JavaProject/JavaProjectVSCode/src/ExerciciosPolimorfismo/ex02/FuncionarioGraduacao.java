package ExerciciosPolimorfismo.ex02;

public class FuncionarioGraduacao extends Funcionario{
    private String universidade;

    public FuncionarioGraduacao(String nome, int codigoFuncional, String universidade) {
        super(nome, codigoFuncional);
        this.universidade = universidade;
    }

    //  Método calcularRenda() que aumenta a renda básica em 50%
    @Override
    public double calcularRenda() {
        return super.calcularRenda() * 2.0;
    }

    @Override
    public String toString() {
        return super.toString() + ", Universidade: " + universidade;
    }
}
