import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.*;

public class main {
    /// Descomponiendo el mapa
    public static void main(String[] args) {
        String mapa = "" +
                "#######\n" +
                "#     #\n" +
                "#     #\n" +
                "#    $#\n" +
                "#     #\n" +
                "# X   #\n" +
                "#     #\n" +
                "#######";

        String[] size = new String[mapa.length()];

        int cont = 0;
        int horizontal2 = 0;
        int vertical2 = 1;

        for (int i = 0; i < mapa.length(); i++) {

            if (mapa.charAt(i) == '\n'){
                vertical2++;

                if(horizontal2 <= cont){
                    horizontal2 = cont;
                    cont = 0;
                    continue;
                }
            }
            cont++;
        }

        out.println(horizontal2);
        out.println(vertical2);


        Bender b = new Bender(mapa);

        int horizontal = 0;
        int vertical = 0;

        for (int i = 0; i < mapa.length(); i++) {
            if (horizontal == 0) {vertical ++;}
            if (mapa.charAt(i) == '\n') {horizontal++;}
        }

        Character[][] mapa2d = new Character[vertical][horizontal];
        Integer[] posicionPersonaje = new Integer[2];

        // Variable para contar el caracter de mapa
        int k = 0;
        //v
        for (int i = 0; i < mapa2d.length; i++) {
            //h
            for (int j = 0; j < mapa2d[0].length; j++) {
                if (mapa.charAt(k) == '\n') {k++;}
                mapa2d[i][j] = mapa.charAt(k);

                // Capturamos el personaje
                if (mapa.charAt(k) == 'X' || mapa.charAt(k) == 'x') {
                    posicionPersonaje[0] = j;
                    posicionPersonaje[1] = i;
                }
                k++;
            }
        }

        for (int i = 0; i < mapa2d.length; i++) {
            for (int j = 0; j < mapa2d[0].length; j++) {
                out.print(mapa2d[i][j]);
            }
            out.println();
        }






        /**/


    }
}
