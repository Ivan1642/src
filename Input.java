import java.util.Scanner;

public class Input {
    public static String getCoordenada(String txt) {
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

    public static char getOrientacion(String orientacion) {

        Scanner sc = new Scanner(System.in);

        char aux;
        do {
            System.out.println(orientacion);
            aux = sc.nextLine().toUpperCase().charAt(0);
        } while (esOrientacionValida(aux));
        return aux;
    }

    public static boolean esOrientacionValida(char aux) {


        if (aux != 'V' || aux != 'H')
            return false;
        else
            return true;

    }

    public static boolean cabe(int barco, String coord, char aux, char[][] tableroJugador) {

        boolean cabe = false;

        if (aux != 'V') {
            if (coord.charAt(1)-'0' + barco <= tableroJugador.length)
                return true;
        } else{
            if (coord.charAt(0)-'A' + barco <= tableroJugador.length)
                return true;
        }

        return cabe;
    }

    public static boolean colisiona(int barco, char[][] tableroJugador, String coord, char orientacion) {

        int fila = coord.charAt(0) - 'A';
        int columna = coord.charAt(1) - '0';
        boolean colision = false;

        if (orientacion == 'H') {
            for (int x = 0; x < barco; x++) {
                if (tableroJugador[fila ][columna+x] == 'B')
                    colision = true;
            }
        } else if (orientacion == 'V') {
            for (int x = 0; x < barco; x++) {
                if (tableroJugador[fila+x][columna ] == 'B')
                    colision = true;
            }
        }
        return colision;
    }


    public static void colocarBarco(int barco, String coord, char aux, char[][] tableroJugador, char[][] tableroDisparosJugador) {

        int fila = coord.charAt(0) - 'A';
        int columna = coord.charAt(1) - '0';

        if (aux == 'H') {
            for (int x = 0; x < barco; x++) {
                tableroJugador[fila][columna + x] = 'B';
            }
        } else if (aux == 'V') {
            for (int x = 0; x < barco; x++) {
                tableroJugador[fila + x][columna] = 'B';
            }
        }
    }
}
