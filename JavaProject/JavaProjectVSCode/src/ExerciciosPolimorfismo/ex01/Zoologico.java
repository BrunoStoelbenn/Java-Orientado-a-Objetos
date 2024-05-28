package ExerciciosPolimorfismo.ex01;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    List<Animal> jaulas = new ArrayList<>(10);
    public void adicionarAnimais(List<Animal> animais){
        for (Animal animal : animais){
            jaulas.add(animal);
        }
        
    }



}
