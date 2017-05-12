package batallanaval;

import java.util.Scanner;

public class BatallaNaval {
    
    
    public Jugador crearJugador(int idJugador, int vidas){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(idJugador, vidas, tablero, new ColocarBarco());
        jugador.setEstado(new ColocarBarco(jugador));
        jugador.getEstado().accion();
        return jugador;
    }
    
    public void Menu(){
        System.out.println ("\nEscoge una opción: \n"
                          + "* 1: Colocar Bomba \n"
                          + "* 2: Ver Tablero \n"
                          + "* 3: Cambiar Barco \n"
                          + "Nota: Al ejecutar cualquier opción, excepto Ver Tablero, se terminara tu turno");
    }
    
    public Jugador CambiarTurno(Jugador jugadorT, Jugador jugador1, Jugador jugador2){
        if(jugadorT.getIdJugador() == 1){
            return jugador2;
        }else{
           return jugador1;
        }
    }
   
    public void Indicador(Jugador jugadorT){
        System.out.println ("Jugador "+jugadorT.getIdJugador()+"  Vidas: "+jugadorT.getVidas());
    }
    
    public int ScannerNum(){
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        return entradaEscaner.nextInt (); //Invocamos un método sobre un objeto Scanner
    }
    
    public Jugador Estado(Jugador jugadorT, Jugador jugador1, Jugador jugador2, BatallaNaval juego){
        int opcion = ScannerNum();
        StateJugador estado;
        switch(opcion){
            case 1: 
                jugadorT.setEstado(new ColocarBomba(juego.CambiarTurno(jugadorT, jugador1, jugador2)));
                jugadorT.accion();
                jugadorT = juego.CambiarTurno(jugadorT, jugador1, jugador2);
                break;
            case 2:
                jugadorT.setEstado(new MostrarTablero(jugadorT));
                jugadorT.accion();
                break;
            case 3:
                jugadorT.setEstado(new CambiarBarco(jugadorT));
                jugadorT.accion();
                jugadorT = juego.CambiarTurno(jugadorT, jugador1, jugador2);
                break;
            default:
                break;
        }
        return jugadorT;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println ("Bienvenido a Batalla Naval \n");
        System.out.println ("¿Con cuántos barcos quieren jugar?");
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        int vidas = entradaEscaner.nextInt (); //Invocamos un método sobre un objeto Scanner
        BatallaNaval juego = new BatallaNaval();
        Jugador jugador1 = juego.crearJugador(1, vidas);
        Jugador jugador2 = juego.crearJugador(2, vidas);
        Jugador jugadorT = jugador1;
        while(jugadorT.getVidas() > 0){
            juego.Indicador(jugadorT);
            juego.Menu();
            jugadorT = juego.Estado(jugadorT, jugador1, jugador2, juego);
            
        }
        
        
    }
    
    
}
