public class ex02aula {
    public static void main(String[] args) {
        CalculadoraEstatistica calculadora = new CalculadoraEstatistica();  // Criei a variável calculador do tipo CalculadoraEstatistica passando como atributo o tamanho do vetor
                    
        calculadora.preencherVetor();  // Chamando o método da classe CalculadoraEstatistica cujo nome é preencherVetor que recebe como Parâmetro o input para preencher o vetor
        calculadora.mostrarVetor();  // Chamando o método mostrarVetor que tem como finalidade mostrar o vetor
        calculadora.maiorValor();  // Chamando o método maioValor que tem como finalidade mostrar o maior valor do vetor
        calculadora.menorValor();  // Chamando o método menorValor que tem como finalidade mostrar o menor valor do vetor
        calculadora.media();  // Chamando o método média que tem como finalidade mostrar a média dos valores do vetor
        calculadora.somatorio();  // Chamando o método somatório que tem como finalidade somar todos os valores do vetor
    }
}
