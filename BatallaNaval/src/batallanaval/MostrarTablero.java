package batallanaval;

public class MostrarTablero extends StateJugador {
    
    public MostrarTablero(){

        }
    
    /*
    * Metodo constructor de la clase MostrarTrablero.
    */
    public MostrarTablero(Jugador jugador){
            this.jugador = jugador;
    }
    
    /**
    * Método que imprime el tablero del jugador.
    */
    @Override
    public void accion(){
        Tablero tablero = jugador.getTablero();
        System.out.println ("\n******************************\n \n "
                          + "Tablero del jugador "+jugador.getIdJugador()+"\n \n"
                          + "******************************\n");
        for (int i=0; i<tablero.getSize(); i++){
            for (int j=0; j<tablero.getSize(); j++){
                System.out.print("|"+tablero.getElement(i, j)+"|");
            }
            System.out.println("");
        }  
    }
    
    public static void main(String[] args) {

    }
}
