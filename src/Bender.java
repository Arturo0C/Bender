import org.jetbrains.annotations.NotNull;

import java.util.*;

class Bender {
    // Constructor: ens passen el mapa en forma d'String

    private char[][] mapa2d;
    private Robot robot = new Robot();
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
                if (mapa.length() == numLletra) { break; }
                if (mapa.charAt(numLletra) == '\n' && j != 0) {
                    numLletra++;
                    break;
                }

                mapa2d[i][j] = mapa.charAt(numLletra);

                // Capturamos el robot
                if (mapa.charAt(numLletra) == 'X' || mapa.charAt(numLletra) == 'x') {
                    robot.setVector(i, j);
                }
                // Capturamos el teleporter
                if (mapa.charAt(numLletra) == 'T' || mapa.charAt(numLletra) == 't') {
                    teleporter.setTpList(contadorTp, new Teleporter(i, j));
                    contadorTp++;
                }
            }
        }

    }

    public String run() {
        return robot.getMovimientos(mapa2d, teleporter);
    }


}

class Robot {

    private int vertical;
    private int horizontal;

    StringBuilder movimientos = new StringBuilder();

    public String getMovimientos(char[][] mapa2d, Teleporter teleporter) {
        move(mapa2d, teleporter);
        return movimientos.toString();
    }

    public void setVector(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }


    boolean canMove(char dir, char[][] mapa2d, Teleporter teleporter) {
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

    void move(@NotNull char[][] mapa2d, Teleporter teleporter) {
        char[] dir = {'S', 'E', 'N', 'W'};
        char[] dirInversa = {'N', 'W', 'S', 'E'};
        char myMove = ' ';

        int esInversa = 0;

        myMove = dir[0];

        while (mapa2d[vertical][horizontal] != '$') {

            if (mapa2d[vertical][horizontal] == 'T') {
                char[] c = teleporter.nextTp(vertical, horizontal);
                vertical = c[0];
                horizontal = c[1];
            }

            if (canMove(myMove, mapa2d, teleporter)) {
                movimientos.append(myMove);
                typeMove(myMove);

                if (mapa2d[vertical][horizontal] == 'I') {
                    esInversa++;
                }

            } else {
                for (int i = 0; i < 4; i++) {
                    if (esInversa % 2 == 0) {
                        if (canMove(dir[i], mapa2d, teleporter)) {
                            myMove = dir[i];
                            break;
                        }
                    } else {
                        if (canMove(dirInversa[i], mapa2d, teleporter)) {
                            myMove = dirInversa[i];
                            break;
                        }
                    }
                }
            }

        }
    }

    void typeMove(char dir) {
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

    private Map<Integer, Teleporter> tpList = new HashMap<>();

    private int vertical;
    private int horizontal;

    Teleporter() {
    }

    Teleporter(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public char[] nextTp(int vertical, int horizontal) {
        char[] resultado = new char[2];
        Map<Double, Teleporter> tpDistances = new HashMap<>();
        Teleporter tp1 = new Teleporter(vertical, horizontal);
        Teleporter tp2;

        // En caso de tener solo dos tp's

        for (Teleporter i : tpList.values()) {
            tp2 = i;
            if (!(equals(tp1, tp2))) {
                tpDistances.put(distanceVector(tp1, i), i);
            }
        }

        Collection<Double> value = tpDistances.keySet();
        ArrayList<Double> listValues = new ArrayList<>(value);
        Collections.sort(listValues);

        Teleporter t = tpDistances.get(listValues.get(0));

        resultado[0] = (char) t.getVertical();
        resultado[1] = (char) t.getHorizontal();

        return resultado;
    }

    public double distanceVector(@NotNull Teleporter tp, @NotNull Teleporter tp2) {
        int v1 = tp.getVertical();
        int h1 = tp.getHorizontal();
        int v2 = tp2.getVertical();
        int h2 = tp2.getHorizontal();

        return Math.sqrt(Math.pow(v2 - v1, 2) + Math.pow(h2 - h1, 2));

    }


    public boolean equals(@NotNull Teleporter tp, @NotNull Teleporter tp2) {
        if (tp.getHorizontal() == tp2.getHorizontal() && tp.getVertical() == tp2.getVertical()) {
            return true;
        } else {
            return false;
        }
    }

    public void setTpList(int i, Teleporter Teleporter) {
        this.tpList.put(i, Teleporter);
    }

    public int getVertical() {
        return vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }
}




