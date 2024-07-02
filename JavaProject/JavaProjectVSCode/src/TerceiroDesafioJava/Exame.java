package TerceiroDesafioJava;

import java.util.Date;

public class Exame {
    private int id;
    private String tipo;
    private String descricao;
    private Date data;
    private Coleta coleta;
    private Diagnostico diagnostico;

    public Exame(int id, String tipo, String descricao, Date data){
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
    }

    public void registrarColeta(Coleta coleta){
        this.coleta = coleta;
    }

    public void registrarDiagnostico(Diagnostico diagnostico){
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString(){
        return "Exame{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", coleta=" + coleta +
                ", diagnostico=" + diagnostico +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Coleta getColeta() {
        return coleta;
    }

    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    
}
