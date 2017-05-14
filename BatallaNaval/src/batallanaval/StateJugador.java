package batallanaval;

public abstract class StateJugador {
    
    // jugador simboliza el Jugador en turno
    public Jugador jugador;
    
    /*
    * Metodo constructor de la clase abastracta StateJugador.
    */
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
