package batallanaval;

public abstract class StateJugador {
    
    public Jugador jugador;

    public void StateJugador(Jugador jugador){
        this.jugador = jugador;
    }
    
    /**
    * Método para ejecutar una acción("CambiarBarco", "Mostrar tablero", "ColocarBomba")
    * dependiendo del estado del jugador
    */
    public void accion(){
    
    }
    
}
