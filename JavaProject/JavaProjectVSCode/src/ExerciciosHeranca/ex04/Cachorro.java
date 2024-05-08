package ex04;

import java.io.IOException;

public class Cachorro extends Animal {
    public Cachorro(){
        super();
    }

    public Cachorro(String caminhoImagem, double peso, String comida) throws IOException{
        super(caminhoImagem, peso, comida);
    }

    public String enterrarOsso(){
        return "O cachorro está enterrando o osso.";
    }
}
