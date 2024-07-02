package TerceiroDesafioJava;

public class Diagnostico {
    private String resultado;
    private String parecer;

    public Diagnostico(String resultado, String parecer){
        this.resultado = resultado;
        this.parecer = parecer;
    }

    @Override
    public String toString(){
        return "Diagnostico{" +
        "resultado='" + resultado + '\'' +
        ", parecer='" + parecer + '\'' +
        '}';
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

    
}
