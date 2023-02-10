import javax.swing.*;

public class hundir_la_flota {

    public static void main(String[] args) {

        char[][] tableroJugador = new char[10][10];
        char[][] tableroPC = new char[10][10];
        char[][] tableroDisparosPC = new char[10][10];
        char[][] tableroDisparosJugador = new char[10][10];
        int[] barcos = new int[4];
        String coord = "";
        int contadorPC = 0;
        int contador = 0;

        rellenarTablerosJugador(tableroJugador, tableroDisparosJugador);
        mostrarTablerosJugador(tableroJugador, tableroDisparosJugador);
        rellenarTablerosPC(tableroPC, tableroDisparosPC);
        mostrarTablerosPC(tableroPC, tableroDisparosPC);
        rellenarBarcos(barcos);
        colocarBarcosJugador(tableroJugador, barcos, tableroDisparosJugador);
        colocarBarcosPC(tableroPC, barcos, tableroDisparosPC);
        do {
            if (disparar(coord, tableroJugador, tableroDisparosJugador, tableroPC)) {
                contador = contador + 1;
            }
            mostrarTablerosJugador(tableroJugador, tableroDisparosJugador);
            if (PC.disparo(coord, tableroJugador, tableroDisparosPC, tableroPC)) {
                contadorPC = contadorPC + 1;
                mostrarTablerosJugador(tableroJugador, tableroDisparosJugador);
            }
        } while (contador < barcos.length || contadorPC < barcos.length);

    }


    public static boolean disparar(String coord, char[][] tableroJugador, char[][] tableroDisparosJugador, char[][] tableroPC) {

        System.out.println();
        String aux = "";

        //coordenadas
        aux = disparos.getCoordenadaDisparo("Introduce coordenadas de disparo: ");
        //disparo
        return disparos.disparo(aux, tableroJugador, tableroDisparosJugador, tableroPC);

    }


    public static void rellenarTablerosJugador(char[][] tableroJugador, char[][] tableroDisparosJugador) {

        //tableroJugador

        for (int x = 0; x < tableroJugador.length; x++) {
            for (int y = 0; y < tableroJugador.length; y++) {
                tableroJugador[x][y] = '~';
            }
        }


        //tableroDisparosJugador

        for (int x = 0; x < tableroDisparosJugador.length; x++) {
            for (int y = 0; y < tableroDisparosJugador.length; y++) {
                tableroDisparosJugador[x][y] = '~';
            }
        }

    }

    public static void rellenarTablerosPC(char[][] tableroPC, char[][] tableroDisparosPC) {

        //tableroPC

        for (int x = 0; x < tableroPC.length; x++) {
            for (int y = 0; y < tableroPC.length; y++) {
                tableroPC[x][y] = '~';
            }
        }


        //tableroDisparosPC

        for (int x = 0; x < tableroDisparosPC.length; x++) {
            for (int y = 0; y < tableroDisparosPC.length; y++) {
                tableroDisparosPC[x][y] = '~';
            }
        }

    }

    public static void mostrarTablerosJugador(char[][] tableroJugador, char[][] tableroDisparosJugador) {

        char letra = 'A';

        //numeros arriba

        System.out.print(" ");
        for (int y = 0; y < tableroJugador.length; y++) {
            System.out.print(" " + y);
        }
        System.out.print("        ");
        for (int y = 0; y < tableroJugador.length; y++) {
            System.out.print(" " + y);
        }
        System.out.println();


        //tableros

        for (int x = 0; x < tableroJugador.length; x++) {
            System.out.print(letra + " ");
            for (int y = 0; y < tableroJugador.length; y++) {
                System.out.print(tableroJugador[x][y] + " ");
            }
            System.out.print(letra);
            System.out.print("     ");
            System.out.print(letra + " ");
            for (int y = 0; y < tableroJugador.length; y++) {
                System.out.print(tableroDisparosJugador[x][y] + " ");
            }
            System.out.print(letra);
            System.out.println();
            letra++;
        }

        //numeros abajo

        System.out.print(" ");
        for (int y = 0; y < tableroJugador.length; y++) {
            System.out.print(" " + y);
        }
        System.out.print("        ");
        for (int y = 0; y < tableroJugador.length; y++) {
            System.out.print(" " + y);
        }
        System.out.println();
    }

    public static void mostrarTablerosPC(char[][] tableroPC, char[][] tableroDisparosPC) {

        char letra = 'A';

        //numeros arriba
        System.out.println();
        System.out.println();
        System.out.print(" ");
        for (int y = 0; y < tableroPC.length; y++) {
            System.out.print(" " + y);
        }
        System.out.print("        ");
        for (int y = 0; y < tableroDisparosPC.length; y++) {
            System.out.print(" " + y);
        }
        System.out.println();


        //tableros

        for (int x = 0; x < tableroPC.length; x++) {
            System.out.print(letra + " ");
            for (int y = 0; y < tableroPC.length; y++) {
                System.out.print(tableroPC[x][y] + " ");
            }
            System.out.print(letra);
            System.out.print("     ");
            System.out.print(letra + " ");
            for (int y = 0; y < tableroPC.length; y++) {
                System.out.print(tableroDisparosPC[x][y] + " ");
            }
            System.out.print(letra);
            System.out.println();
            letra++;
        }

        //numeros abajo

        System.out.print(" ");
        for (int y = 0; y < tableroPC.length; y++) {
            System.out.print(" " + y);
        }
        System.out.print("        ");
        for (int y = 0; y < tableroDisparosPC.length; y++) {
            System.out.print(" " + y);
        }

    }

    public static void borrarPantalla(String[] limpiar) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void rellenarBarcos(int[] barcos) {

        /*    1 barco que ocupa 4 cuadrados.
        2 barcos de tres cuadros
        3 barcos de 2 cuadros
        4 barcos de un solo cuadro*/

        barcos[0] = 4;
        barcos[1] = 3;
        barcos[2] = 2;
        barcos[3] = 1;


    }

    public static void colocarBarcosJugador(char[][] tableroJugador, int[] barcos, char[][] tableroDisparosJugador) {

        String coord;
        char orientacion;
        boolean colocado;
        int barco;

        System.out.println();

        for (int i = 0; i < barcos.length; i++) {
            barco = barcos[i];
            colocado = false;
            do {
                System.out.println();
                System.out.println("El tamaño del barco a colocar es " + barco);
                // solicitar una coordenada valida
                coord = Input.getCoordenada("Introduce una coordenada: ");
                // solicitar una orientacion valida
                orientacion = Input.getOrientacion("Introduce la orientación('V' o 'H'): ");
                // comprobar si cabe el barco
                if (Input.cabe(barco, coord, orientacion, tableroJugador)) {
                    // comprobar si colisiona el barco
                    if (!Input.colisiona(barco, tableroJugador, coord, orientacion)) {
                        // colocar el barco
                        Input.colocarBarco(barco, coord, orientacion, tableroJugador, tableroDisparosJugador);
                        colocado = true;
                        mostrarTablerosJugador(tableroJugador, tableroDisparosJugador);
                    } else
                        System.out.println("Colisiona");
                } else
                    System.out.println("No cabe");
            }
            while (!colocado);
        }
    }

    public static boolean cabePC(int barco, String coord, char aux, char[][] tableroPC) {

        boolean cabe = false;

        if (aux != 'V') {
            if ((coord.charAt(1) - '0' + barco) < tableroPC.length)
                return true;
        } else if (aux != 'H') {
            if (coord.charAt(0) - 'A' + barco < tableroPC.length)
                return true;
        }

        return cabe;
    }

    public static boolean colisionaPC(int barco, char[][] tableroPC, String coord, char orientacionPC) {

        int fila = coord.charAt(0) - 'A';
        int columna = coord.charAt(1) - '0';
        boolean colision = false;

        if (orientacionPC == 'H') {
            for (int x = 0; x < barco; x++) {
                if (tableroPC[fila][columna + x] == 'B')
                    colision = true;
            }
        } else if (orientacionPC == 'V') {
            for (int x = 0; x < barco; x++) {
                if (tableroPC[fila + x][columna] == 'B')
                    colision = true;
            }
        }
        return colision;
    }

    public static void colocarPC(int barco, String coord, char aux, char[][] tableroPC, char[][] tableroDisparosPC) {

        int fila = coord.charAt(0) - 'A';
        int columna = coord.charAt(1) - '0';

        if (aux == 'H') {
            for (int x = 0; x < barco; x++) {
                tableroPC[fila][columna + x] = 'B';
            }
        } else if (aux == 'V') {
            for (int x = 0; x < barco; x++) {
                tableroPC[fila + x][columna] = 'B';
            }
        }
    }

    public static void colocarBarcosPC(char[][] tableroPC, int[] barcos, char[][] tableroDisparosPC) {

        String coord;
        char orientacionPC;
        boolean colocado;
        int barco;
        int random;

        for (int i = 0; i < barcos.length; i++) {
            barco = barcos[i];
            colocado = false;
            do {
                //coordenadas
                int num = (int) (Math.random() * 10);
                char letra = (char) (Math.random() * ('J' - 'A' + 1) + 'A');
                coord = letra + "" + num;

                //orientacion
                random = (int) (Math.random() * 10);

                if (random <= 4)
                    orientacionPC = 'V';
                else
                    orientacionPC = 'H';

                // comprobar si cabe el barco
                if (cabePC(barco, coord, orientacionPC, tableroPC)) {
                    // comprobar si colisiona
                    if (!colisionaPC(barco, tableroPC, coord, orientacionPC)) {
                        int fila = coord.charAt(0) - 'A';
                        int columna = coord.charAt(1) - '0';

                        if (orientacionPC == 'H') {
                            for (int x = 0; x < barco; x++) {
                                tableroPC[fila][columna + x] = 'B';
                            }
                        } else if (orientacionPC == 'V') {
                            for (int x = 0; x < barco; x++) {
                                tableroPC[fila + x][columna] = 'B';
                            }
                        }
                        colocado = true;
                    }
                }
            } while (!colocado);
        }
    }
}