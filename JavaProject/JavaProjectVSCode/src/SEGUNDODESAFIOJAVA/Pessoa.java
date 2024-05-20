package SEGUNDODESAFIOJAVA;

public class Pessoa {
    private int matricula;
    private String nome;
    private String endereco;

    public Pessoa(int matricula, String nome, String endereco) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
    }

    // Getters e Setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + ", Nome: " + nome + ", Endereco: " + endereco;
    }
}
