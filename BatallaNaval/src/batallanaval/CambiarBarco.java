package batallanaval;
import static batallanaval.Tablero.Scanner;
import static batallanaval.Tablero.convertir;
/*
*Se necesita modular el código de los estados, checar las excepciones
*/

public class CambiarBarco extends StateJugador{
    
    public CambiarBarco(){
        
        }
    
    public CambiarBarco(Jugador jugador){
            this.jugador = jugador;
        }
    @Override
    public void accion(){
        System.out.println ("Introduce las coordenadas << (n,n) >> de el barco a cambiar:");
        String entradaTeclado = Scanner();
        int[] coordenadas = null;
        try {
           coordenadas = convertir(entradaTeclado);
        }catch (RuntimeException e){
            System.out.println("El formato de las coordenadas no es el correcto, intenta con: << (n,n) >>");
            jugador.accion();
        }
        Tablero tablero = jugador.getTablero();
        if(tablero.buscarBarco(coordenadas[0], coordenadas[1])){
            System.out.println("Introduce las coordenadas << (n,n) >> en donde se establecera el barco:");
            String entradaTec = Scanner();
            int[] coord = convertir(entradaTec);
            if(!tablero.buscarBarco(coord[0], coord[1])){
                tablero.borrarBarco( coordenadas[0], coordenadas[1]);
                tablero.colocarBarco(coord[0], coord[1]);
                System.out.println("Tu barco se a cambiado a las coordenadas: ("+coord[0]+","+coord[1]+")");
            }else{
                System.out.println ("Un barco ya ocupa estas coordenas, intentalo de nuevo");
                jugador.accion();
            }
        }else{
            System.out.println ("No existe un barco en esas coordenadas, intentalo de nuevo");
            jugador.accion();
        }
    }

    public static void main(String[] args) {

    }
}
