package batallanaval;

import static batallanaval.Tablero.Scanner;
import static batallanaval.Tablero.convertir;

public class ColocarBarco extends StateJugador{
    
    public ColocarBarco(){
    
    }
    
    /*
    * Metodo constructor de la clase ColocarBarco
    */
    public ColocarBarco(Jugador jugador){
        this.jugador = jugador;
    }
    
    /**
     * Método para colocar n barcos en el tablero donde n es el número de barcos con los que se va a jugar
     */
    @Override
    public void accion(){
        int barcos = jugador.getVidas();
        Tablero tablero = jugador.getTablero();
        for (int i=1; i<=barcos; i++){
            situarBarco(tablero, i);
        }
    }
    /**
     * Método para colocar un barco
     * @param tablero simboliza el tablero donde se esta jugando
     * @param i simboliza la posición que se encuentra el en for
     */
    
    public void situarBarco(Tablero tablero, int i){
        System.out.println ("\nJugador "+jugador.getIdJugador()+": Introduce las coordenadas (n,#) del barco "+i+":\n"
                          + "n es una letra de A hasta H y # es un número de 0 hasta 7");
        String posicion = Scanner();
        if(tablero.validar(posicion)){
            int[] coordenadas = convertir(posicion);
            if(!tablero.buscarBarco(coordenadas[0], coordenadas[1])){
                tablero.colocarBarco(coordenadas[0], coordenadas[1]);
            }else{
                error(1, tablero, i);
            }
        }else{
            error(2, tablero, i);
        }
    }
    
    /**
     * Método para resolver flujos alternativos 
     * @param numError número del error a resolver 
     * @param tablero simboliza el tablero donde se esta jugando
     * @param i simboliza la posición que se encuentra el en for
     */
    public void error(int numError, Tablero tablero, int i){
        switch(numError){
            case 1:
                System.out.println ("\nUn barco ya ocupa estas coordenas, intentalo de nuevo");
                situarBarco(tablero, i);
                break;
            case 2:
                System.out.println ("\nEl formato de las coordenadas es incorrecto, intentalo de nuevo");
                situarBarco(tablero, i);
                break;
            default:
                break;
        }
    }
    
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(1,2,tablero,new ColocarBarco());
        jugador.setEstado(new ColocarBarco(jugador));
        jugador.accion();
    }
    
}
