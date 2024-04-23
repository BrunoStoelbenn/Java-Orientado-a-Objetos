public class main {
    public static void main(String[] args) {
        veiculo escort = new veiculo();
        String placaVeiculoEscort = "IJK4255";
        String modeloVeiculoEscort = "Escort Zetec 1.8 16v";
        String fabricanteVeiculoEscort = "Ford" ;
        int kmVeiculoEscort = 35000;
        int anoFabVeiculoEscort = 2000;
  
        escort.def_dados(placaVeiculoEscort, modeloVeiculoEscort, fabricanteVeiculoEscort, kmVeiculoEscort, anoFabVeiculoEscort);
        escort.mostrar_dados();
       
        veiculo sandero = new veiculo();
        String placaVeiculoSandero = "IJK4259";
        String modeloVeiculoSandero = "Sandero 1.6";
        String fabricanteVeiculoSandero = "Renault" ;
        int kmVeiculoSandero = 20000;
        int anoFabVeiculoSandero = 2014;
        sandero.def_dados(placaVeiculoSandero, modeloVeiculoSandero, fabricanteVeiculoSandero, kmVeiculoSandero, anoFabVeiculoSandero);

        sandero.mostrar_dados();
        sandero.ret_ano();
        sandero.ret_km();
        
    }
}
