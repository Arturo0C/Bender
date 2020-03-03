import java.lang.reflect.Array;
import java.util.*;

class Bender {
    // Constructor: ens passen el mapa en forma d'String

    private char[][] mapa2d;
    private Robot robot = new Robot();
    /* private Map<Integer, Teleporter> listaTp = new HashMap<>();*/

    public Bender(String mapa) {

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
                /*if (mapa.charAt(numLletra) == 'T' || mapa.charAt(numLletra) == 't') {
                    listaTp.put(contadorTp, new Teleporter(i, j));
                    robot.setListaTp(listaTp);
                }*/
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

// S E N W
// N W S E
class Robot {

    private int vertical;
    private int horizontal;
    private Map<Integer, Teleporter> listaTp;

    StringBuilder movimientos = new StringBuilder();

    public void setListaTp(Map<Integer, Teleporter> listaTp) {
        this.listaTp = listaTp;
    }

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

        while (mapa2d[v][h] != '$') {
            if (mapa2d[v + 1][h] != '#') {
                while (mapa2d[v + 1][h] == ' ') {
                    movimientos.append("S");
                    v++;
                    if (mapa2d[v + 1][h] == '$') {
                        movimientos.append("S");
                        v++;
                        break;
                    }
                }
            } else if (mapa2d[v][h + 1] != '#') {
                while (mapa2d[v][h + 1] == ' ') {
                    movimientos.append("E");
                    h++;
                    if (mapa2d[v][h + 1] == '$') {
                        movimientos.append("E");
                        h++;
                        break;
                    }
                }
            } else if (mapa2d[v - 1][h] != '#') {
                while (mapa2d[v - 1][h] == ' ') {
                    movimientos.append("N");
                    v--;
                    if (mapa2d[v - 1][h] == '$') {
                        movimientos.append("N");
                        v--;
                        break;
                    }
                }
            } else if (mapa2d[v][h - 1] != '#') {
                while (mapa2d[v][h - 1] == ' ') {
                    movimientos.append("W");
                    h--;
                    if (mapa2d[v][h - 1] == '$') {
                        movimientos.append("W");
                        h--;
                        break;
                    }
                }
            }
        }
    }
}

    class Teleporter {
            private int vertical;
            private int horizontal;

            Teleporter(int vertical, int horizontal) {
                this.vertical = vertical;
                this.horizontal = horizontal;
            }

            public int getVertical() {
                return vertical;
            }

            public int getHorizontal() {
                return horizontal;
            }
        }



   /* if (mapa2d[v][h + 1] == '#') {aux++;break;}
                    if (mapa2d[v + 1][h] == ' ' || mapa2d[v + 1][h] == '$') {
                        while (mapa2d[v + 1][h] == ' ') {
                            movimientos.append("S");
                            v++;
                            if (mapa2d[v + 1][h] == '$') { movimientos.append("S"); v++; break;}
                        }
                    }*/
