package ex03;

// Criar uma superclasse Funcionario (nome, cpf, salario), no mínimo dois métodos.
// • Criar quatro subclasses (Gerente, Engenheiro, Secretaria, Diretor), criar no mínimo dois métodos específicos para
// cada subclasse.
// Regra 1: Todo ano os funcionários do banco recebem uma bonificação. Os funcionários comuns recebem 10% do
// salário e os gerentes 15%. (criar o método getBonificacao() na classe Funcionario(mae)).
// - Como fazer para o gerente receber 15% ?
// OBS: (uma opção é criar o método na getBonificaçãoGerente() na classe gerente. Qual o problema? Dois métodos de
// bonificação em gerente (confunde quem usar o método, gera dois resultados diferente). Resolver o problema com
// reescrita (override)
// Regar 2: Mudar a forma de calcular a bonificação do gerente, agora é da mesma forma que o funcionário mas
// adicionando mais R$ 1000,00. Já para a secretária, adicionar mais R$ 100,00, para o diretor mais R$ 2000,00 , para o
// engenheiro R$ 550,00. Como fazer isso (faça da mesma forma sugerida na questão 1, @override)?
// Regra 3: Aumentar o percentual de bonificação do funcionário para 20%, como ficaria o código?
// Regra 4: Usando a palavra super, modifique seu código nos métodos de bonificação (depois altere a bonificação do
// funcionário para 30%), consegue ver a diferença e em quantos lugares precisou modificar seu código?
public class ex03 {
    public static void main(String[] args) {
        

        Diretor diretor = new Diretor("Bruno Stoelbenn", "476.986.970-07", 6000);

        System.out.println(diretor.toString());

        System.out.println(diretor.getBonificacao() + diretor.getSalario());

        Gerente gerente = new Gerente("Jonathas Santos", "590.101.680-79", 8000);

        System.out.println(gerente.getSalario());
        System.out.println(gerente.getBonificacao());
    }
}
