

import java.io.IOException;

import ex04.*;

public class ex04 {
    public static void main(String[] args) {
        try {
            Cachorro cachorro = new Cachorro("Cachorro.jpg", 25.5, "Ração para cachorro");
        } 
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
