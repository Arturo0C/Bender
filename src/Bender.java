import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Bender {
    // Constructor: ens passen el mapa en forma d'String

    char[][] mapa2d;
    Robot robot = new Robot();

    //Posicion de X

    public Bender(String mapa) {
        //longitud del mapa
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
                cont = 0;
            }
            cont++;
        }

        this.mapa2d = new char[vertical][horizontal];

        // Variable para contar el caracter de mapa
        int numLletra = 0; //no pude superar el tamaño de el mapa
        //v
        for (int i = 0; i < vertical; i++) {
            //h
            for (int j = 0; j < horizontal + 1; j++, numLletra++) {
                if (mapa.length() == numLletra) {
                    break;
                }
                if (mapa.charAt(numLletra) == '\n' && j != 0) {
                    numLletra++;
                    break;
                }

                mapa2d[i][j] = mapa.charAt(numLletra);

                // Capturamos el personaje
                if (mapa.charAt(numLletra) == 'X' || mapa.charAt(numLletra) == 'x') {
                    robot.setVertical(i);
                    robot.setHorizontal(j);
                }

            }
            if (mapa.length() == numLletra) {
                break;
            }
        }


    }

    // Navegar fins a l'objectiu («$»).

    // El valor retornat pel mètode consisteix en una cadena de
    // caràcters on cada lletra pot tenir
    // els valors «S», «N», «W» o «E»,
    // segons la posició del robot a cada moment.

    public String run() {
        return robot.getMovimientos(mapa2d);
    }
}

// S E N O
class Robot {
    private int vertical;
    private int horizontal;

    StringBuilder movimientos = new StringBuilder();

    public String getMovimientos(char[][] mapa2d) {
        move(vertical, horizontal, mapa2d);
        return movimientos.toString();
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    void move(int vertical, int horizontal, char[][] mapa2d) {
        int v = vertical;
        int h = horizontal;
        // els valors «S», «N», «W» o «E»

        int aux = 1;

        while (mapa2d[v][h] != '$') {
            switch (aux) {
                case 1:
                    if (mapa2d[v + 1][h] == '#') { aux++; break;}
                    if (mapa2d[v + 1][h] == ' ' || mapa2d[v + 1][h] == '$') {
                        movimientos.append("S");
                        v++;
                    }
                    break;
                case 2:
                    if (mapa2d[v][h + 1] == '#') {aux++;break;}
                    if (mapa2d[v][h + 1] == ' ' || mapa2d[v][h + 1] == '$') {
                        movimientos.append("E");
                        h++;
                    }
                    break;
                case 3:
                    if (mapa2d[v - 1][h] == '#') {
                        aux++;
                        break;
                    }
                    if (mapa2d[v - 1][h] == ' ' || mapa2d[v - 1][h] == '$') {
                        movimientos.append("N");
                        v--;
                    }
                    break;
                case 4:
                    if (mapa2d[v][h - 1] == '#') {
                        aux = 1;
                        break;
                    }
                    if (mapa2d[v][h - 1] == ' ' || mapa2d[v][h - 1] == '$') {
                        movimientos.append("W");
                        h--;
                    }
                    break;
            }
        }

    }
}

class Teleporter{
    private int vertical;
    private int horizontal;

    Teleporter() {}

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public int getVertical() {
        return vertical;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public int getHorizontal() {
        return horizontal;
    }
}
