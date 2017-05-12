package batallanaval;

public class MostrarTablero extends StateJugador {
    
    public MostrarTablero(){

        }

    public MostrarTablero(Jugador jugador){
            this.jugador = jugador;
        }
    
    @Override
    public void accion(){
        Tablero tablero = jugador.getTablero();
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
