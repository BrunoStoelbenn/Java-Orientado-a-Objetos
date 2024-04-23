package EXERCICIOSMETODOSESTATICOS;

public class ex01 {
    
    public static double conversaoKilometroMilha(double kilometro){
        double distanciaMilhas = (kilometro * 0.621371);
        return distanciaMilhas;
    }

    public static void main(String[] args) {
        double distanciaTerraLua = 382000;
        System.out.println(conversaoKilometroMilha(distanciaTerraLua));
    }
}
