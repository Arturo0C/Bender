import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


import static java.lang.System.*;

public class main {
    /// Descomponiendo el mapa
    public static void main(String[] args) {
        List<Character> aux = new ArrayList<>();
        aux.add('1');
        aux.add('2');
        aux.add('3');
        aux.add('4');
        Iterator<Character> it = aux.iterator();
        it = aux.iterator();
        out.println(it.next());
        int i = it.next();
        out.println(i);

        int aux2 = 1;
        while (2 == 2) {
            switch(aux2) {
                case 1:
                    out.println("1");
                    aux2++;
                    break;
                case 2:
                    out.println("2");
                    aux2++;
                    break;
                case 3:
                    out.println("3");
                    aux2++;
                    break;
                case 4:
                    out.println("4");
                    aux2 = 1;
                    break;
            }
        }
    }
}

