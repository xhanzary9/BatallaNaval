package batallanaval;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BatallaNaval {
    
    /**
     * Método Juego el cual se encarga de la lógica del juego "Batalla Naval"
     */
    public void Juego(){
        System.out.println ("\n¿Con cuántos barcos quieren jugar?");
        int vidas;
        try{
        vidas = ScannerNum();
        }catch(InputMismatchException e){
            vidas = 0;
        }
        if(vidas < 65 && vidas > 0){
            Jugador jugador1 = crearJugador(1, vidas);
            Jugador jugador2 = crearJugador(2, vidas);
            Jugador jugadorT = jugador1;
            while(jugadorT.getVidas() > 0){
                Indicador(jugadorT);
                Menu();
                jugadorT = opciones(jugadorT, jugador1, jugador2);  
            }
            jugadorT = CambiarTurno(jugadorT, jugador1, jugador2);
            if(jugadorT.getVidas() > 0){
                System.out.println ("\n******************************\n \n "
                                  + "El jugador "+jugadorT.getIdJugador()+" ha ganado \n \n"
                                  + "******************************");
            }
        }else{
            System.out.println ("\nEl número de barcos no es valido, "
                              + "El número de barcos debe ser mayor que 0 y menor que 65");
            Juego();
            
        }       
    }
    
    /**
    * Método para scannear un número y devolverlo
    * @return regresa el número que el usuario inserto
    */
    public int ScannerNum(){
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        return entradaEscaner.nextInt (); //Invocamos un método sobre un objeto Scanner
    }
    
    /**
    * Método para crear un jugador y devolverlo
     * @param idJugador simboliza el id del jugador que se va a crear
     * @param vidas simboliza el número de vidas que tendra el jugador
    * @return regresa el jugador creado
    */
    public Jugador crearJugador(int idJugador, int vidas){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(idJugador, vidas, tablero, new ColocarBarco());
        jugador.setEstado(new ColocarBarco(jugador));
        jugador.getEstado().accion();
        return jugador;
    }
    
    /**
    * Método para imprimir quien es el jugador en turno y el número de vidas que se tiene
     * @param jugadorT simboliza el jugador en turno
    */
    public void Indicador(Jugador jugadorT){
        System.out.println ("\n******************************\n \n"
                          + " Jugador "+jugadorT.getIdJugador()+"  Vidas: "+jugadorT.getVidas()+"\n \n"
                          + "******************************");
    }
    
    /**
    * Método para imprimir el menú al cual el usuario tiene acceso
    */
    public void Menu(){
        System.out.println ("\nEscoge una opción: \n"
                          + "* 1: Colocar Bomba \n"
                          + "* 2: Ver Tablero \n"
                          + "* 3: Cambiar Barco \n"
                          + "Nota: Al ejecutar cualquier opción, excepto Ver Tablero, se terminara tu turno");
    }
    
    /**
    * Método para ejecutar la acción escogida y el cambio de turno
     * @param jugadorT simboliza el jugador en turno
     * @param jugador1 simboliza el jugador 1
     * @param jugador2 simboliza el jugador 2
     * @return jugadorT, nos devuelve el jugador para el siguiente turno
    */
    public Jugador opciones(Jugador jugadorT, Jugador jugador1, Jugador jugador2){
         int opcion;
        try{
            opcion = ScannerNum();
        }catch(InputMismatchException e){
            opcion = 4;
            System.out.println ("\n La opción que escogiste no es valida, vuelve a intentarlo");
        }
        switch(opcion){
            case 1: 
                jugadorT.setEstado(new ColocarBomba(CambiarTurno(jugadorT, jugador1, jugador2)));
                jugadorT.accion();
                jugadorT = CambiarTurno(jugadorT, jugador1, jugador2);
                break;
            case 2:
                jugadorT.setEstado(new MostrarTablero(jugadorT));
                jugadorT.accion();
                break;
            case 3:
                jugadorT.setEstado(new CambiarBarco(jugadorT));
                jugadorT.accion();
                jugadorT = CambiarTurno(jugadorT, jugador1, jugador2);
                break;
            default:
                break;
        }
        return jugadorT;
    }
    
    /**
    * Método para hacer el cambio de turno
     * @param jugadorT simboliza el jugador en turno
     * @param jugador1 simboliza el jugador 1
     * @param jugador2 simboliza el jugador 2
     * @return nos devuelve el jugador para el siguiente turno
    */
    public Jugador CambiarTurno(Jugador jugadorT, Jugador jugador1, Jugador jugador2){
        if(jugadorT.getIdJugador() == 1){
            return jugador2;
        }else{
           return jugador1;
        }
    }

    /**
     * Método main el cual se encarga de la inicialización del juego "Batalla Naval"
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println ("******************************\n \n"
                          + "Bienvenido a Batalla Naval \n \n"
                          + "****************************** \n");
        BatallaNaval juego = new BatallaNaval();
        juego.Juego();
    }
    
    
}
