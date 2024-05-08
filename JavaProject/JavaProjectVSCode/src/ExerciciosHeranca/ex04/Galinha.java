package ex04;

import java.io.IOException;

public class Galinha extends Ave {
    public Galinha(){
        super();
    }

    public Galinha(String caminhoImagem, double peso, String comida) throws IOException{
        super(caminhoImagem, peso, comida);
    }

}
