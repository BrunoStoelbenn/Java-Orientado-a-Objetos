package ex04;

import java.io.IOException;

public class Coruja extends Ave {
    public Coruja(){
        super();
    }

    public Coruja(String caminhoImagem, double peso, String comida) throws IOException{
        super(caminhoImagem, peso, comida);
    }

}
