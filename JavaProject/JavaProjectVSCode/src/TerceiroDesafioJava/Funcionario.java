package TerceiroDesafioJava;

public class Funcionario extends Usuario {

    public Funcionario(int id, String nome, String senha, String papel) {
        super(id, nome, senha, papel);
    }

    public void lancarRequisicao(Requisicao requisicao) {
        SistemaExames.requisicoes.add(requisicao);
    }

    public void registrarColeta(Exame exame, Coleta coleta) {
        exame.registrarColeta(coleta);
    }

    public void registrarDiagnostico(Exame exame, Diagnostico diagnostico) {
        exame.registrarDiagnostico(diagnostico);
    }
}
