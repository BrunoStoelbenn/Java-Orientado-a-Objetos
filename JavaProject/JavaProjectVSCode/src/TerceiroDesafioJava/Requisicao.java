package TerceiroDesafioJava;
import java.util.ArrayList;
import java.util.List;

public class Requisicao {
    private int id;
    private Paciente paciente;
    private Medico Medico;
    private List<Exame> exames;

    public Requisicao(Medico medico, Paciente paciente, List<Exame> exames){
        this.Medico = medico;
        this.paciente = paciente;
        this.exames = exames;
    }

    public void adicionarExame(Exame exame){
        exames.add(exame);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return Medico;
    }

    public void setMedico(Medico medico) {
        Medico = medico;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    
}
