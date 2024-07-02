package TerceiroDesafioJava;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario {
    private List<Requisicao> requisicoes;

    public Paciente(int id, String nome, String senha) {
        super(id, nome, senha, "PACIENTE");
        this.requisicoes = new ArrayList<>();
    }

    public void consultarExames() {
        for (Requisicao requisicao : requisicoes) {
            System.out.println("Requisição do médico: " + requisicao.getMedico().getNome());
            for (Exame exame : requisicao.getExames()) {
                System.out.println(exame);
            }
        }
    }

    public void adicionarRequisicao(Requisicao requisicao) {
        requisicoes.add(requisicao);
    }

    public List<Requisicao> getRequisicoes() {
        return requisicoes;
    }

    public void setRequisicoes(List<Requisicao> requisicoes) {
        this.requisicoes = requisicoes;
    }

}
