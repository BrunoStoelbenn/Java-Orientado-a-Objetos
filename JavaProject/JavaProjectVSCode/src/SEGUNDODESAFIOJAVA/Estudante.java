package SEGUNDODESAFIOJAVA;

public class Estudante extends Pessoa {
    private int anoIngresso;
    private String curso;

    public Estudante(int matricula, String nome, String endereco, int anoIngresso, String curso) {
        super(matricula, nome, endereco);
        this.anoIngresso = anoIngresso;
        this.curso = curso;
    }

    // Getters e Setters
    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return super.toString() + ", Ano Ingresso: " + anoIngresso + ", Curso: " + curso;
    }
}

