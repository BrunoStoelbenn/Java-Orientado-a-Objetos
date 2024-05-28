package ExerciciosPolimorfismo.ex01;

public class Cavalo extends Animal{
        
    public Cavalo(String nome, int idade){
        super(nome, idade);
    }

    @Override
    public String emitirSom(){
        return getNome() + " está relinchando.";
    }
}
