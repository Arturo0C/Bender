class Bender {
    // Constructor: ens passen el mapa en forma d'String

    //Crea el string que el valor es igual a un salto de linea



    Character[][] mapa2d;
    Integer[] posicionPersonaje = new Integer[2];

    public Bender(String mapa) {
        // Posicion del personaje

        int horizontal = 0;
        int vertical = 0;

        for (int i = 0; i < mapa.length(); i++) {
            if (horizontal == 0) {vertical ++;}
            if (mapa.charAt(i) == '\n') {horizontal++;}
        }

        this.mapa2d = new Character[vertical][horizontal];

        // Variable para contar el caracter de mapa
        int k = 0;
        //v
        for (int i = 0; i < mapa2d.length; i++) {
            //h
            for (int j = 0; j < mapa2d[0].length; j++) {
                if (mapa.charAt(k) == '\n') {k++; break;}
                mapa2d[i][j] = mapa.charAt(k);

                // Capturamos el personaje
                if (mapa.charAt(k) == 'X' || mapa.charAt(k) == 'x') {
                    posicionPersonaje[0] = j;
                    posicionPersonaje[1] = i;
                }
                k++;
            }
        }

    }

    public Character[][] getMapa2d() {
        return mapa2d;
    }

    public Integer[] getPosicionPersonaje() {
        return posicionPersonaje;
    }


    // Navegar fins a l'objectiu («$»).

    // El valor retornat pel mètode consisteix en una cadena de
    // caràcters on cada lletra pot tenir
    // els valors «S», «N», «W» o «E»,
    // segons la posició del robot a cada moment.

    public String run() {
        return ""; }
}

class Personaje {

    Personaje() {

    }

    void moveUp() {

    }
}
