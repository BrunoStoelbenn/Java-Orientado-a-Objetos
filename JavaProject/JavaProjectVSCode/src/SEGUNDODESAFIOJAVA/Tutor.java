package SEGUNDODESAFIOJAVA;

public class Tutor extends Pessoa {
    private float salarioMensal;
    private String areaFormacao;

    public Tutor(int matricula, String nome, String endereco, float salarioMensal, String areaFormacao) {
        super(matricula, nome, endereco);
        this.salarioMensal = salarioMensal;
        this.areaFormacao = areaFormacao;
    }

    // Getters e Setters
    public float getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(float salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    public String getAreaFormacao() {
        return areaFormacao;
    }

    public void setAreaFormacao(String areaFormacao) {
        this.areaFormacao = areaFormacao;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salario Mensal: " + salarioMensal + ", Area Formacao: " + areaFormacao;
    }
}

