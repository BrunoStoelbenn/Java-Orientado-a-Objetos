package ExerciciosPolimorfismo.ex01;

public class Cachorro extends Animal{
    
    public Cachorro(String nome, int idade){
        super(nome, idade);
    }

    @Override
    public String emitirSom(){
        return getNome() + " está latindo.";
    }
}
