package batallanaval;

public interface StateJugador {
    
    /**
    * Método para ejecutar una acción("CambiarBarco", "Mostrar tablero", "ColocarBomba")
    * dependiendo del estado del jugador
     * @param tablero
    */
    public void accion(Tablero tablero);
    
}
