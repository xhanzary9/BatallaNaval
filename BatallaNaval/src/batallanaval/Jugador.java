
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
    
    public Jugador(){
    }
    
     /**
     * Metodo constructor  de la clase abastracta Jugador.
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

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }
    
    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public StateJugador getEstado() {
        return estado;
    }

    public void setEstado(StateJugador estado) {
        this.estado = estado;
    }
    
    public void accion() {
        estado.accion();
    }
    
    
}
