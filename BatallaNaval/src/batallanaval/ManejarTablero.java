package batallanaval;

public interface ManejarTablero {
     
     /**
     * Metodo que se encarga de ver si se encuentra un barco en las coordenadas dadas
     * @param coordx
     * @param coordy
     * @param tablero
     * @return true si se encuentra un barco en esas coordenadas, false en otro caso
     */
    public boolean buscarBarco(int coordx, int coordy, Tablero tablero);
     
     /**
     * Metodo que se encarga de colocar un barco en una coordenada especifica
     * @param coordx
     * @param coordy
     * @param tablero
     */
    public void colocarBarco(int coordx, int coordy, Tablero tablero);
      
     /**
     * Metodo que se encarga de colocar una bomba en una coordenada especifica
     * @param coordx
     * @param coordy
     * @param tablero
     */
    public void colocarBomba(int coordx, int coordy, Tablero tablero);
    
     /**
     * Metodo que se encarga de borrar un barco de una coordenada especifica
     * @param coordx
     * @param coordy
     * @param tablero
     */
    public void borrarBarco(int coordx, int coordy, Tablero tablero);
    
}
