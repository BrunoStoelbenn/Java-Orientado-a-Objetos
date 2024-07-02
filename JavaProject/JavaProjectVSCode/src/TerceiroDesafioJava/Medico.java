package TerceiroDesafioJava;
import java.util.ArrayList;
import java.util.List;

public class Medico extends Usuario {
    private List<Requisicao> requisicoes;

    public Medico(int id, String nome, String senha) {
        super(id, nome, senha, "MEDICO");
        this.requisicoes = new ArrayList<>();
    }

    public void criarRequisicao(Paciente paciente, List<Exame> exames) {
        Requisicao requisicao = new Requisicao(this, paciente, exames);
        requisicoes.add(requisicao);
        paciente.adicionarRequisicao(requisicao);
    }

    public List<Requisicao> getRequisicoes() {
        return requisicoes;
    }

    public void setRequisicoes(List<Requisicao> requisicoes) {
        this.requisicoes = requisicoes;
    }

}
