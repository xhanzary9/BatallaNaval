
package batallanaval;

public class Jugador {
   /*
    * vidas entero que simboliza las vidas de el jugador
    * numero entero que simboliza el número del jugador "Jugador 1" o "Jugador 2"
    * tablero entero que simboliza el número de tablero que tiene el jugador
    */
    private int idJugador;
    private int vidas; 
    private Tablero tablero;
    private StateJugador estado;
    
    /*
    * Método constructor de la clase Jugador
    */
    public Jugador(){
    }
    
    /**
    * Metodo constructor  de la clase Jugador.
    * @param idJugador
    * @param vidas  número de vidas que se asignal al jugador.
    * @param tablero
    * @param estado
    */
    public Jugador(int idJugador, int vidas, Tablero tablero, StateJugador estado){
        
        this.idJugador = idJugador;
        this.vidas = vidas;
        this.tablero = tablero;
        this.estado = estado;
    }   
    
    /*
    * Método get que devuelven el id del jugador.
    */
    public int getIdJugador() {
        return idJugador;
    }
    
    /*
    * Método set que cambia el id del jugador.
    */
    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }
    
    /*
    * Método get que devuelve las vidas del jugador.
    */
    public int getVidas() {
        return vidas;
    }
    
    /*
    * Método set que cambia las vidas del jugador.
    */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
    /*
    * Método get que devuelven el tablero del jugador.
    */
    public Tablero getTablero() {
        return tablero;
    }
    
    /*
    * Método set que cambia el tablero del jugador.
    */
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    
    /*
    * Método get que devuelven el estado del jugador.
    */
    public StateJugador getEstado() {
        return estado;
    }
    
    /*
    * Método set que cambia el estado del jugador.
    */
    public void setEstado(StateJugador estado) {
        this.estado = estado;
    }
    
    /*
    * Método accion que ejecuta la acción del estado donde se encuentra el jugador.
    */
    public void accion() {
        estado.accion();
    }
    
    
}
