package ExerciciosPolimorfismo.ex01;

import java.util.ArrayList;
import java.util.List;

public class ex01 {
    public static void main(String[] args) {
        //  Criando uma arraylist do tipo Animal para colocar os animais que mais tarde irão ser adicionados nas jaulas
        List<Animal> animais = new ArrayList<>();
        Animal galinha = new Animal("Galinha", 2);
        Cachorro brutus = new Cachorro("Brutus", 11);
        Cachorro sadan = new Cachorro("Sadan", 4);
        Cachorro pipo = new Cachorro("Pipo", 1);
        Cavalo pedipano = new Cavalo("Pedipano", 15);
        Cavalo branco = new Cavalo("Branco", 6);
        Animal gato = new Animal("Gato", 3);
        Animal rex = new Cachorro("Rex", 5);    
        Preguica preguica = new Preguica("Preguiça", 6);
        Animal papagaio = new Animal("Papagaio", 2);
        //  Adicionando os animais na arraylist animais
        animais.add(galinha);
        animais.add(brutus);
        animais.add(sadan);
        animais.add(pipo);
        animais.add(pedipano);
        animais.add(branco);
        animais.add(gato);
        animais.add(rex);
        animais.add(preguica);
        animais.add(papagaio);

        //  Criando uma instância da classe Zoologico para ter acesso aos seus atributos e métodos
        Zoologico zoologico = new Zoologico();
        //  Enviando a arraylist de animais para serem colocados na arraylist de jaulas da classe zoologico
        zoologico.adicionarAnimais(animais);

        //  Chamando o método estático emitirSomLocomocao enviando como atributo o arraylist jaulas que está dentro da classe zoologico
        emitirSomLocomocao(zoologico.jaulas);

        System.out.println("Saída do método estático emitirSom(Animal animal)");
        //  Prints para testar o método estático de emitirSom que recebe como parâmetro um animal.
        System.out.println(emitirSom(galinha));
        System.out.println(emitirSom(brutus));
        System.out.println(emitirSom(pedipano));
        System.out.println(emitirSom(preguica));
        System.out.println();

        System.out.println("Saída do método estático examinar(Animal animal) da classe Veterinario");
        //  Prints para testar o método estático examinar() da classe Veterinario que recebe como parâmetro um animal.
        System.out.println(Veterinario.examinar(galinha));
        System.out.println(Veterinario.examinar(brutus));
        System.out.println(Veterinario.examinar(pedipano));
        System.out.println(Veterinario.examinar(preguica));
    }

    public static String emitirSom(Animal animal){
        return animal.emitirSom();
    }

    public static void emitirSomLocomocao(List<Animal> animais){
        for(Animal animal : animais){
            System.out.println(animal.emitirSom());
            System.out.println(animal.locomocao());
            System.out.println();
        }
    }
}
