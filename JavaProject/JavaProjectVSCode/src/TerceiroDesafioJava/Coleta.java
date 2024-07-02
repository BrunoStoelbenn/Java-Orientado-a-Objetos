package TerceiroDesafioJava;

import java.util.Date;

public class Coleta {
    private int quantidade;
    private Date hora;

    public Coleta(int quantidade, Date hora){
        this.quantidade = quantidade;
        this.hora = hora;
    }

    @Override
    public String toString(){
        return "Coleta{" +
                "quantidade=" + quantidade +
                ", hora=" + hora +
                '}';
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    
}
