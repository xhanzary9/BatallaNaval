package batallanaval;

import static batallanaval.Tablero.Scanner;
import static batallanaval.Tablero.convertir;

public class ColocarBarco extends StateJugador{
    
    public ColocarBarco(){
    
    }
    
    public ColocarBarco(Jugador jugador){
        this.jugador = jugador;
    }
    
    @Override
    public void accion(){
        int barcos = jugador.getVidas();
        Tablero tablero = jugador.getTablero();
        for (int i=1; i<=barcos; i++){
            System.out.println ("Jugador "+jugador.getIdJugador()+": Introduce las coordenadas << (n,n) >> del barco "+i+":");
            String entradaTeclado = Scanner();
            int[] coordenadas = convertir(entradaTeclado);
            if(!tablero.buscarBarco(coordenadas[0], coordenadas[1])){
                tablero.colocarBarco(coordenadas[0], coordenadas[1]);
            }else{
                System.out.println ("En esa posición ya se encuentra un barco");
                //Aquí hacerlo más modular para poder ejecutar la misma función 
            }
        }

    }
}
