import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

class Bender {
    // Constructor: ens passen el mapa en forma d'String

    private char[][] mapa2d;
    private Robot robot = new Robot();
    /* private Map<Integer, Teleporter> listaTp = new HashMap<>();*/
    private Teleporter teleporter = new Teleporter();

    //El string del mapa can't be null
    public Bender(@NotNull String mapa) {

        int horizontal = 0;
        int vertical = 1;
        //longitud del mapa
        int cont = 0;

        //Longitud del array
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

        int numLletra = 0;
        int contadorTp = 1;

        for (int i = 0; i < vertical; i++) {
            for (int j = 0; j < horizontal + 1; j++, numLletra++) {
                if (mapa.length() == numLletra) {
                    break;
                }
                if (mapa.charAt(numLletra) == '\n' && j != 0) {
                    numLletra++;
                    break;
                }

                mapa2d[i][j] = mapa.charAt(numLletra);

                // Capturamos el robot
                if (mapa.charAt(numLletra) == 'X' || mapa.charAt(numLletra) == 'x') {
                    robot.setVertical(i);
                    robot.setHorizontal(j);

                }
                // Capturamos el teleporter
                if (mapa.charAt(numLletra) == 'T' || mapa.charAt(numLletra) == 't') {
                        teleporter.setTp(new Teleporter(i,j));
                }
            }
            if (mapa.length() == numLletra) {
                break;
            }
        }

    }

    public String run() {
        return robot.getMovimientos(mapa2d);
    }


}

class Robot {

    private int vertical;
    private int horizontal;

    StringBuilder movimientos = new StringBuilder();

    public String getMovimientos(char[][] mapa2d) {
        move(mapa2d);
        return movimientos.toString();
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    boolean canMove(char dir, char[][] mapa2d) {
        int v = vertical;
        int h = horizontal;

        if (dir == 'S') {
            if ((mapa2d[v + 1][h] != '#')) {
                return true;
            } else if (mapa2d[v + 1][h] == '$') {
                vertical++;
                movimientos.append('S');
                return false;
            } else {
                return false;
            }
        } else if (dir == 'E') {
            if ((mapa2d[v][h + 1] != '#')) {
                return true;
            } else if (mapa2d[v][h + 1] == '$') {
                horizontal++;
                movimientos.append('E');
                return false;
            } else {
                return false;
            }
        } else if (dir == 'N') {
            if ((mapa2d[v - 1][h] != '#')) {
                return true;
            } else if (mapa2d[v - 1][h] == '$') {
                vertical--;
                movimientos.append('N');
                return false;
            } else {
                return false;
            }
        } else if (dir == 'W') {
            if ((mapa2d[v][h - 1] != '#')) {
                return true;
            } else if (mapa2d[v][h - 1] == '$') {
                horizontal--;
                movimientos.append('W');
                return false;
            } else {
                return false;
            }
        } else return false;
    }

    void move(char[][] mapa2d) {
        char[] dir = {'S', 'E', 'N', 'W'};
        char[] dirInversa = {'N', 'W', 'S', 'E'};
        char myMove = ' ';

        int esInversa = 0;

        myMove = dir[0];

        while (mapa2d[vertical][horizontal] != '$') {
            if (canMove(myMove, mapa2d)) {
                    movimientos.append(myMove);
                    tipoMovi(myMove);
                if (mapa2d[vertical][horizontal] == 'I') {myMove = dirInversa[0]; esInversa++; }
            } else {
                for (int i = 0; i < 4; i++) {
                   if (esInversa%2 == 0) {
                       if (canMove(dir[i], mapa2d)) {
                           myMove = dir[i];
                           break;
                       }
                   } else {
                       if (canMove(dirInversa[i], mapa2d)) {
                           myMove = dirInversa[i];
                           break;
                       }
                   }
                }
            }

        }
    }

    void tipoMovi(char dir) {
        if (dir == 'S') {
            vertical++;
        } else if (dir == 'E') {
            horizontal++;
        } else if (dir == 'N') {
            vertical--;
        } else if (dir == 'W') {
            horizontal--;
        }
    }

}

class Teleporter {
    List<Teleporter> tp = new ArrayList<>();

    private int vertical;
    private int horizontal;

    Teleporter() {

    }

    Teleporter(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public List<Teleporter> getTp() {
        return tp;
    }

    public void setTp(Teleporter tp) {
        this.tp.add(tp);
    }

    public int getVertical() {
        return vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }


}




