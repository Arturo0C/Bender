import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.*;

public class main {
    /// Descomponiendo el mapa
    public static void main(String[] args) {
        String mapa = "" +
                "   #######\n" +
                "   # XTI #\n" +
                "   #    $#\n" +
                "####    #####\n" +
                "#          T#\n" +
                "####     ####\n" +
                "   #    I#\n" +
                "   #     #\n" +
                "   #######";


        // Calculamos la longitud de el mapa
        int cont = 0;
        int horizontal = 0;
        int vertical = 1;


        for (int i = 0; i < mapa.length(); i++) {

            if (mapa.charAt(i) == '\n') {
                vertical++;

                if (horizontal <= cont) {
                    horizontal = cont;
                    cont = 0;
                    continue;
                }
            }
            cont++;
        }

        out.println(vertical);
        out.println(horizontal);
        out.println(mapa.length());

        Character[][] mapa2d = new Character[vertical][horizontal];
        Integer[] posicionPersonaje = new Integer[2];

        /*
        // Variable para contar el caracter de mapa
        int k = 0; //no pude superar el tamaño de el mapa
        //v
        for (int i = 0; i < mapa2d.length; i++) {
            //h
            for (int j = 0; j < mapa2d[0].length; j++) {
                mapa2d[i][j] = mapa.charAt(k);
                k++;
                // Capturamos el personaje
                if (mapa.charAt(k) == 'X' || mapa.charAt(k) == 'x') {
                    posicionPersonaje[0] = j;
                    posicionPersonaje[1] = i;
                }
            }
        }*/

        for (int i = 0; i < mapa2d.length; i++) {
            for (int j = 0; j < mapa2d[0].length; j++) {
                out.print(mapa2d[i][j]);
            }
            out.println();
        }






        /**/


    }
}
