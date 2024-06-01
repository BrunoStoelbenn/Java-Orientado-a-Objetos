package ExerciciosPolimorfismo.ex02;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        // Adiciona funcionários à lista
        funcionarios.add(new FuncionarioEnsinoBasico("Maria", 2, "Escola A"));
        funcionarios.add(new FuncionarioEnsinoBasico("Pedro", 3, "Escola B"));
        funcionarios.add(new FuncionarioEnsinoMedio("Ana", 4, "Escola C"));
        funcionarios.add(new FuncionarioEnsinoMedio("Paulo", 5, "Escola D"));
        funcionarios.add(new FuncionarioGraduacao("Lucas", 6, "Universidade X"));
        funcionarios.add(new FuncionarioGraduacao("Fernanda", 7, "Universidade Y"));
        funcionarios.add(new Vendedor(new FuncionarioEnsinoBasico("Clara", 8, "Escola G")));
        funcionarios.add(new Supervisor(new FuncionarioEnsinoMedio("Rafael", 9, "Escola H")));
        funcionarios.add(new Gerente(new FuncionarioGraduacao("Beatriz", 10, "Universidade Z")));

        // Calcula e imprime os custos
        double totalSalarios = 0;
        double totalBasico = 0;
        double totalMedio = 0;
        double totalGraduacao = 0;

        for (Funcionario funcionario : funcionarios) {
            double salario = funcionario.calcularRenda();
            totalSalarios += salario;
            
            //  Inicializa funcionarioBase com o funcionário atual da iteração.
            Funcionario funcionarioBase = funcionario;
            //  Verifica se o funcionarioBase é uma instância de ComissaoDecorator.
            //  O loop continua enquanto funcionarioBase for uma instância de ComissaoDecorator.
            while (funcionarioBase instanceof ComissaoDecorator) {
                //  Faz o casting de funcionarioBase para ComissaoDecorator e obtém o funcionário base original.
                //  Isso é feito para "desempacotar" os decoradores e obter o funcionário base subjacente.
                funcionarioBase = ((ComissaoDecorator) funcionarioBase).funcionario;
                
}

            if (funcionarioBase instanceof FuncionarioGraduacao) {
                totalGraduacao += salario;
            } else if (funcionarioBase instanceof FuncionarioEnsinoMedio) {
                totalMedio += salario;
            } else if (funcionarioBase instanceof FuncionarioEnsinoBasico) {
                totalBasico += salario;
            }

            System.out.println(funcionario.toString());
        }

        System.out.println("Total de salários: " + totalSalarios);
        System.out.println("Total de salários (Ensino Básico): " + totalBasico);
        System.out.println("Total de salários (Ensino Médio): " + totalMedio);
        System.out.println("Total de salários (Graduação): " + totalGraduacao);
    }
}
