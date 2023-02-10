public class PC {

    public static boolean disparo(String coord, char[][] tableroJugador, char[][] tableroDisparosPC, char[][] tableroPC){

        int num = (int) (Math.random() * 10);
        char letra = (char) (Math.random() * ('J' - 'A' + 1) + 'A');
        coord = letra + "" + num;

        //coordenadas
        int fila = coord.charAt(0) - 'A';
        int columna = coord.charAt(1) - '0';

        boolean acierto = false;

        if (tableroJugador[fila][columna] == 'B')
            acierto = true;

        if (acierto) {
            tableroDisparosPC[fila][columna] = '*';
            tableroJugador[fila][columna] = 'T';
            System.out.println();
            System.out.println("El PC te ha tocado el barco");
        } else {
            tableroDisparosPC[fila][columna] = 'X';
            System.out.println();
            System.out.println("El PC ha fallado");
        }

        return acierto;
    }

}
