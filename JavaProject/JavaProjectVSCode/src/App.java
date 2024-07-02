public class App {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int resultado = 0;

        for(i=0; i<=10; i++){
            System.out.println();
            System.out.println("Tabuada do " + i);
            for(j=0; j<=10; j++){
                resultado = i * j;
                System.out.println(i + " X " + j + " = " + resultado);
            }
        }

    }
}