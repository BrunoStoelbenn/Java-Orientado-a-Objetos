public class ex01metodosestaticos {
    
    public static double conversaoKilometroMilha(double kilometro){
        double distanciaMilhas = (kilometro * 0.621371);
        return distanciaMilhas;
    }

    public static double conversaoKilometroPes(double kilometro){
        double distanciaPes = (kilometro * 3281);
        return distanciaPes;
    }

    public static void main(String[] args) {
        double distanciaTerraLua = 382000;
        System.out.println(conversaoKilometroMilha(distanciaTerraLua));
        System.out.println(conversaoKilometroPes(distanciaTerraLua));
    }
}
