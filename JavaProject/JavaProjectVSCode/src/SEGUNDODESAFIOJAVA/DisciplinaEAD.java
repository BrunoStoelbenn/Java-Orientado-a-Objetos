package SEGUNDODESAFIOJAVA;

public class DisciplinaEAD extends Disciplina {
    private int numeroUnidades;

    public DisciplinaEAD(int codigo, String nome, String ementa, int numeroUnidades) {
        super(codigo, nome, ementa);
        this.numeroUnidades = numeroUnidades;
    }

    // Getters e Setters
    public int getNumeroUnidades() {
        return numeroUnidades;
    }

    public void setNumeroUnidades(int numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numero de Unidades: " + numeroUnidades;
    }
}

