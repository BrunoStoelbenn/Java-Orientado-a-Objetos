package SEGUNDODESAFIOJAVA;

public class Professor extends Pessoa {
    private String titulacao;
    private float valorHora;

    public Professor(int matricula, String nome, String endereco, String titulacao, float valorHora) {
        super(matricula, nome, endereco);
        this.titulacao = titulacao;
        this.valorHora = valorHora;
    }

    // Getters e Setters
    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return super.toString() + ", Titulacao: " + titulacao + ", Valor Hora: " + valorHora;
    }
}

