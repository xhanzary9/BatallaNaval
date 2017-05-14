package batallanaval;
import static batallanaval.Tablero.Scanner;
import static batallanaval.Tablero.convertir;

public class ColocarBomba extends StateJugador {
    
    public ColocarBomba(){
        
        }
    
    /*
    * Metodo constructor de la clase ColocarBomba.
    */
    public ColocarBomba(Jugador jugador){
            this.jugador = jugador;
        }
    
    /**
    * Método que lanza una bomba a el tablero del oponente dadas unas coordenadas.
    */
    @Override
    public void accion(){
        System.out.println ("\nIntroduce las coordenadas (n,#) donde se arrojara la bomba:\n"
                          + "n es una letra de A hasta H y # es un número de 0 hasta 7");
        String posicion = Scanner();
        int[] coordenadas;
        Tablero tablero = jugador.getTablero(); 
        if(tablero.validar(posicion)){
            coordenadas = convertir(posicion);
            lanzarBomba(coordenadas, tablero);
        }else{
             error();
        } 
    }
    
    /**
    * Método que lanza una bomba a el tablero del oponente si se encuentra un barco.
     * @param coordenadas simboliza la posición en la que se lanzara una bomba. 
     * @param tablero simboliza el tablero del oponente.
    */
    public void lanzarBomba(int[] coordenadas, Tablero tablero){
        if(tablero.buscarBarco(coordenadas[0], coordenadas[1])){
            tablero.borrarBarco( coordenadas[0], coordenadas[1]);
            tablero.colocarBomba(coordenadas[0], coordenadas[1]);
            jugador.setVidas(jugador.getVidas() - 1);
            System.out.println ("\n******************************\n\n"
                              + "Le haz dado a un barco, ¡Genial!\n\n"
                              + "******************************\n");
        }else{
            System.out.println ("\nNo le haz atinado a nada, suerte para la próxima");
            tablero.colocarBomba(coordenadas[0], coordenadas[1]);
        }
    }
    
    /**
     * Método para resolver flujos alternativos
     */
    public void error(){
        System.out.println ("\nEl formato de las coordenadas es incorrecto, intentalo de nuevo");
        accion();
    }
    
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(1,2,tablero,new ColocarBomba());
        jugador.setEstado(new ColocarBomba(jugador));
        jugador.accion();
    }
}
