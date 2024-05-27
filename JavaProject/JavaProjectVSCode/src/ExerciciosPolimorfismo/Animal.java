package ExerciciosPolimorfismo;

public class Animal {
    private String nome;
    private int idade;
    private String som;
    private String movimento;

    public Animal(String nome, int idade, String som, String movimento){
        this.nome = nome;
        this.idade = idade;
        this.som = som;
        this.movimento = movimento;
    }

    public String getNome(){
        return this.nome;
    }

    
}
