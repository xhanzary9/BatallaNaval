package batallanaval;
import static batallanaval.Tablero.Scanner;
import static batallanaval.Tablero.convertir;

public class ColocarBomba extends StateJugador {
    
    public ColocarBomba(){
        
        }
    
    public ColocarBomba(Jugador jugador){
            this.jugador = jugador;
        }
    
    @Override
    public void accion(){
        System.out.println ("Introduce las coordenadas << (n,n) >> donde se arrojara la bomba:");
        String entradaTeclado = Scanner();
        int[] coordenadas = convertir(entradaTeclado);
        Tablero tablero = jugador.getTablero(); 
        if(tablero.buscarBarco(coordenadas[0], coordenadas[1])){
            tablero.borrarBarco( coordenadas[0], coordenadas[1]);
            tablero.colocarBomba(coordenadas[0], coordenadas[1]);
            jugador.setVidas(jugador.getVidas() - 1);
            System.out.println ("Le haz dado a un barco, ¡Genial!");
        }else{
            System.out.println ("No le haz atinado a nada, surte para la próxima");
            tablero.colocarBomba(coordenadas[0], coordenadas[1]);
        }
        
    }
    
    public static void main(String[] args) {

    }
}
