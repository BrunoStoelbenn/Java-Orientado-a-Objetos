package ex04;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Animal {
    protected Image imagem;
    protected double peso;
    protected String comida;

    public Animal(){

    }

    public Animal(String caminhoImagem, double peso, String comida) throws IOException{
        this.imagem = carregarImagem(caminhoImagem);
        this.peso = peso;
        this.comida = comida;
    }

    // Método para carregar a imagem do arquivo
    private Image carregarImagem(String caminhoImagem) throws IOException {
        File arquivo = new File(caminhoImagem);
        return ImageIO.read(arquivo);
    }

    public Image getImagem(){
        return imagem;
    }

    public void setImagem(Image image){
        this.imagem = image;
    }

    public Double getPeso(){
        return peso;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public String getComida(){
        return comida;
    }

    public void setComida(String comida){
        this.comida = comida;
    }

    public String comer(){
        return "O animal está comendo " + comida;
    }

    public String Dormir(){
        return "O animal está dormindo.";
    }

    public String movimentar(){
        return "O animal está se movimentando";
    }

    public String fazerBarulho(){
        return "O animal está fazendo barulho.";
    }

}
