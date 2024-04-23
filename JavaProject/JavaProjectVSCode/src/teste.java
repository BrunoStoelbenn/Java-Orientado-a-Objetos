import java.util.Scanner;
public class teste {

    public static int maior(int x, int y){
        if (x > y) return x;
        else return y;
    }
    public static void main (String [] args){
        int m, x, y;

        Scanner input = new Scanner(System.in);

        x = input.nextInt();
        y = input.nextInt();

        m = maior(x, y);

        System.out.println(m);
    }
}
