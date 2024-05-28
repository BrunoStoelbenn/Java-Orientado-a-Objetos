package ExerciciosPolimorfismo.ex01;

public class Animal {
    private String nome;
    private int idade;
    
    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String emitirSom(){
        return getNome() + " está emitindo um som.";
    }

    public String locomocao(){
        return getNome() + " está correndo.";
    }

    


    
}
