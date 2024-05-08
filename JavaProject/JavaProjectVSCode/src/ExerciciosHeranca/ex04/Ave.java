package ex04;

import java.io.IOException;

public class Ave extends Animal {
    public Ave(){
        super();
    }

    public Ave(String caminhoImagem, double peso, String comida) throws IOException{
        super(caminhoImagem, peso, comida);
    }

    public String voar(){
        return "A ave está voando";
    }

    public String botarOvo(){
        return "A ave está ponhando um ou uns ovo(s).";
    }
}
