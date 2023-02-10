import java.util.Scanner;

public class disparos {


    public static String getCoordenadaDisparo(String txt) {
        Scanner sc = new Scanner(System.in);
        String coord;
        do {
            System.out.println(txt);
            coord = sc.nextLine().toUpperCase();
        } while (!esCoordenadaValida(coord));
        return coord;
    }

    public static boolean esCoordenadaValida(String coord) {

        if (coord.length() != 2)
            return false;

        if (coord.charAt(0) > 'J' || coord.charAt(0) < 'A')
            return false;

        if (coord.charAt(1) < '0' || coord.charAt(1) > '9')
            return false;
        else
            return true;
    }

    public static boolean disparo(String coord, char[][] tableroJugador, char[][] tableroDisparosJugador, char[][] tableroPC) {

        int fila = coord.charAt(0) - 'A';
        int columna = coord.charAt(1) - '0';
        boolean acierto = false;

        if (tableroPC[fila][columna] == 'B')
            acierto = true;

        if (acierto) {
            tableroDisparosJugador[fila][columna] = '*';
            tableroPC[fila][columna] = 'T';
            System.out.println("Tocado");
        } else {
            tableroDisparosJugador[fila][columna] = 'X';
            System.out.println("Has fallado");
        }
        return acierto;
    }

}
