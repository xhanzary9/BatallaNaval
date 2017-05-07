package batallanaval;

public class Tablero {
  
    /*
    * jugador entero que simboliza el número del jugador "Jugador 1" o "Jugador 2"
    * tablero Matriz que simboliza el tablero que tiene el jugador
    */
    private int jugador;
    private int[][] tablero; 
    
    public Tablero(){
    }
    
     /**
     * Metodo constructor  de la clase abastracta Jugador.
     * @param jugador  número del jugador "Jugador 1" o "Jugador 2".
     * @param tablero Matriz que se le asocia al tablero.
     */
    public Tablero(int jugador, int[][] tablero){
   
        this.jugador = jugador;
        this.tablero = tablero;

    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
    
    
}
