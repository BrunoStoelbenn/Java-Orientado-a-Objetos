package SEGUNDODESAFIOJAVA;

public class Matricula {
    private Estudante estudante;
    private Horario horario;

    public Matricula(Estudante estudante, Horario horario) {
        this.estudante = estudante;
        this.horario = horario;
    }

    // Getters e Setters
    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Estudante: " + estudante.getNome() + ", Disciplina: " + horario.getDisciplina().getNome();
    }
}

