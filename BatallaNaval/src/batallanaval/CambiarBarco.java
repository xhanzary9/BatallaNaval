package batallanaval;
import static batallanaval.Tablero.Scanner;
import static batallanaval.Tablero.convertir;
/*
*Se necesita modular el código de los estados, checar las excepciones
*/

public class CambiarBarco extends StateJugador{
    
    public CambiarBarco(){
        
        }
    
    /*
    * Metodo constructor de la clase CambiarBarco.
    */
    public CambiarBarco(Jugador jugador){
            this.jugador = jugador;
        }
    
    /**
     * Método para cambiar un barco de posición
     */
    @Override
    public void accion(){
        System.out.println ("\nIntroduce las coordenadas (n,#) de el barco a cambiar:\n"
                          + "n es una letra de A hasta H y # es un número de 0 hasta 7 ");
        Tablero tablero = jugador.getTablero();
        String posicion = Scanner();
        int[] coordenadas = null;
        if(tablero.validar(posicion)){
            coordenadas = convertir(posicion);
            if(tablero.buscarBarco(coordenadas[0], coordenadas[1])){
                 colocarBarco(coordenadas, tablero);
            }else{
                error(1,coordenadas, tablero);
            }
        }else{
            errorf(1,coordenadas, tablero);
        }
    }

    /**
     * Método para verificar que las coordenadas donde se quiere cambiar el barco
     * esten en el formato aceptado y para colocar barco
     * @param coordenadas arreglo que simboliza las coordenadas del barco a cambiar
     * @param tablero simboliza el tablero en donde se esta jugando
     */
    public void colocarBarco(int[] coordenadas, Tablero tablero){
        System.out.println("\nIntroduce las coordenadas (n,#) en donde se establecera el barco:\n"
                         + "n es una letra de A hasta H y # es un número de 0 hasta 7");
        String posicion2 = Scanner();
        if(tablero.validar(posicion2)){
            int[] coord = convertir(posicion2);
            modificarPosicion( coordenadas, coord, tablero, posicion2);
        }else{
            errorf(2, coordenadas, tablero);
        }
    }
    
    /**
     * Método para cambiar el barco de posición
     * @param coordenadas arreglo que simboliza las coordenadas del barco a cambiar
     * @param coord arreglo que simboliza las coordenadas donde se quiere cambiar al barco
     * @param tablero simboliza el tablero donde se esta jugando
     * @param posicion2 simboliza las coordenadas donde se quiere cambiar el barco pero en tipo string
     */
    public void modificarPosicion(int[] coordenadas, int[] coord, Tablero tablero, String posicion2){
        if(!tablero.buscarBarco(coord[0], coord[1])){
            tablero.borrarBarco( coordenadas[0], coordenadas[1]);
            tablero.colocarBarco(coord[0], coord[1]);
            System.out.println("\nTu barco se a cambiado a las coordenadas: "+posicion2);
        }else{
            error(2,coordenadas, tablero);
        }
    }
    
    /**
     * Método para resolver flujos alternativos
     * @param error número del error a resolver
     * @param coordenadas arreglo que simboliza las coordenadas del barco a cambiar 
     * @param tablero simboliza el tablero donde se esta jugando
     */
    public void error(int error, int[] coordenadas, Tablero tablero){
        switch(error){
            case 1:
                System.out.println ("\nNo existe un barco en esas coordenadas, intentalo de nuevo");
                accion();
                break;
            case 2:
                System.out.println ("\nUn barco ya ocupa estas coordenas, intentalo de nuevo");
                colocarBarco(coordenadas, tablero);
                break;
            default:
                break;
        }
        
    }
    
    /**
     * Método para resolver flujos alternativos debido al formato de las coordenadas
     * @param error número del error a resolver
     * @param coordenadas arreglo que simboliza las coordenadas del barco a cambiar 
     * @param tablero simboliza el tablero donde se esta jugando
     */
    public void errorf(int error, int[] coordenadas, Tablero tablero){
        switch(error){
            case 1:
                System.out.println ("\nEl formato de las coordenadas es incorrecto, intentalo de nuevo");
                accion();
                break;
            case 2:
                System.out.println ("\nEl formato de las coordenadas es incorrecto, intentalo de nuevo");
                colocarBarco(coordenadas, tablero);
                break;
            default:
                break;
        }
        
    }
    
    public static void main(String[] args) {

    }
}
