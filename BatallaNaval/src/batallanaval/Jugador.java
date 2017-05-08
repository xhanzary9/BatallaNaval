
package batallanaval;

public class Jugador {
   /*
    * vidas entero que simboliza las vidas de el jugador
    * numero entero que simboliza el número del jugador "Jugador 1" o "Jugador 2"
    * tablero entero que simboliza el número de tablero que tiene el jugador
    */
    private int vidas;
    private int numero; 
    private Tablero tablero;
    private StateJugador estado;
    
    public Jugador(){
    }
    
     /**
     * Metodo constructor  de la clase abastracta Jugador.
     * @param vidas  número de vidas que se asignal al jugador.
     * @param numero entero que identifica al jugador.
     * @param tablero
     * @param estado
     */
    public Jugador(int vidas, int numero, Tablero tablero, StateJugador estado){
   
        this.vidas = vidas;
        this.numero = numero;
        this.tablero = tablero;
        this.estado = estado;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
    
    public void accion(Tablero tablero) {
        estado.accion(tablero);
    }
}
