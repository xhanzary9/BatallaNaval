package batallanaval;
import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java

public class CambiarBarco implements StateJugador{

    @Override
    public void accion(Tablero tablero) {
        
        System.out.println ("Por favor introduzca una cadena por teclado:");
        String entradaTeclado;
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        System.out.println ("Entrada recibida por teclado es: \"" + entradaTeclado +"\"");
    }
    
    /**
     *Metodo para
     */
    public void main(){
        Tablero tab = new Tablero();
        accion(tab);
    }
}
