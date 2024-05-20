package SEGUNDODESAFIOJAVA;

public class DisciplinaPresencial extends Disciplina {
    private int numeroAulas;

    public DisciplinaPresencial(int codigo, String nome, String ementa, int numeroAulas) {
        super(codigo, nome, ementa);
        this.numeroAulas = numeroAulas;
    }

    // Getters e Setters
    public int getNumeroAulas() {
        return numeroAulas;
    }

    public void setNumeroAulas(int numeroAulas) {
        this.numeroAulas = numeroAulas;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numero de Aulas: " + numeroAulas;
    }
}


