package SEGUNDODESAFIOJAVA;

public class Horario {
    private Disciplina disciplina;
    private Professor professor;
    private Tutor tutor; // Usado apenas para disciplinas EAD
    private int numeroVagas;
    private String diaSemana; // Usado apenas para disciplinas presenciais
    private String turno; // Usado apenas para disciplinas presenciais

    // Construtor para disciplinas presenciais
    public Horario(Disciplina disciplina, Professor professor, int numeroVagas, String diaSemana, String turno) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.numeroVagas = numeroVagas;
        this.diaSemana = diaSemana;
        this.turno = turno;
    }

    // Construtor para disciplinas EAD
    public Horario(Disciplina disciplina, Professor professor, Tutor tutor, int numeroVagas) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.tutor = tutor;
        this.numeroVagas = numeroVagas;
    }

    // Getters e Setters
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public int getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(int numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        String info = "Disciplina: " + disciplina.getNome() + ", Professor: " + professor.getNome() + ", Vagas: " + numeroVagas;
        if (disciplina instanceof DisciplinaPresencial) {
            info += ", Dia da Semana: " + diaSemana + ", Turno: " + turno;
        } else if (disciplina instanceof DisciplinaEAD) {
            info += ", Tutor: " + tutor.getNome();
        }
        return info;
    }
}

