package batallanaval;

public class ManejarTableroJugador implements ManejarTablero {
    
    @Override
    public boolean buscarBarco(int coordx, int coordy, Tablero jugadorTab){
       int[][] tab = jugadorTab.getTablero();
       return tab[coordx][coordy] == 1;
    }
    
    @Override
    public void colocarBarco(int coordx, int coordy, Tablero jugadorTab){
        int[][] tab = jugadorTab.getTablero();
        tab[coordx][coordy] = 1;
        jugadorTab.setTablero(tab);
    }
    
    @Override
    public void colocarBomba(int coordx, int coordy, Tablero jugadorTab){
        int[][] tab = jugadorTab.getTablero();
        tab[coordx][coordy] = 2;
        jugadorTab.setTablero(tab);
    }
    
    @Override
    public void borrarBarco(int coordx, int coordy, Tablero jugadorTab){
        int[][] tab = jugadorTab.getTablero();
        tab[coordx][coordy] = 0;
        jugadorTab.setTablero(tab);
    }
}
