import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        String mapa = "" +
                "###########\n" +
                "#T       $#\n" +
                "#  ########\n" +
                "#         #\n" +
                "#         #\n" +
                "#         #\n" +
                "#       ###\n" +
                "#    XT   #\n" +
                "###########";
        Bender bender = new Bender(mapa);

        Map<Integer, Teleporter> tpList = bender.getTeleporter().getTpList();
        System.out.println(bender.getRobot().getHorizontal()+1);
        for (Teleporter i: tpList.values()) {
            System.out.println(i.getHorizontal());
        }
    }



}