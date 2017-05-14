package batallanaval;

import java.util.Scanner;
import java.util.regex.*;


public class Tablero {
  
    /*
    * Matriz que simboliza el tablero que tiene el jugador
    */
    private int[][] tablero; 
    
    /*
    * Metodo constructor  de la clase Jugador de tamaño 8x8.
    */
    public Tablero(){
  
        this.tablero = new int[8][8];

    }

    /*
    * Metodo constructor  de la clase Jugador de tamaño nxn.
    */    
    public Tablero(int n) {
        this.tablero = new int[n][n];
    }

    /*
    * Metodo get para obtener el tablero del jugador.
    */    
    public int[][] getTablero() {
        return tablero;
    }

    /*
    * Metodo set para modificar el tablero del jugador.
    */
    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
    
    /*
    * Metodo get para obtener el tamaño del tablero del jugador.
    */
    public int getSize() {
        return this.tablero.length;
    }
    
    /*
    * Metodo get para obtener el elemento que se encuetra en la posición dada.
    * @param n número que representa la columna n
    * @param m númeor que represneta el renglon m
    */
    public int getElement(int n, int m) {
        return this.tablero[n][m];
    }
    
    /**
    * Método para buscar un barco en una coordenada dada
    * @param coordx representa la coordenada x en el tablero del jugador
    * @param coordy representa la coordenada x en el tablero del jugador
    * @return true si se encontro un barco en esa posición, else si no hay barco alguno.
    */
    public boolean buscarBarco(int coordx, int coordy){
       int[][] tab = this.getTablero();
       return tab[coordy][coordx] == 1;
    }

    /**
    * Método para agregar un barco en una coordenada dada
    * @param coordx representa la coordenada x en el tablero del jugador
    * @param coordy representa la coordenada x en el tablero del jugador
    */
    public void colocarBarco(int coordx, int coordy){
        int[][] tab = this.getTablero();
        tab[coordy][coordx] = 1;
    }
    
    /**
    * Método para lanzar una bomba en una coordenada dada
    * @param coordx representa la coordenada x en el tablero del jugador oponente
    * @param coordy representa la coordenada x en el tablero del jugador oponente
    */
    public void colocarBomba(int coordx, int coordy){
        int[][] tab = this.getTablero();
        tab[coordy][coordx] = 2;
    }
    
    /**
    * Método para borrar un barco en una coordenada dada
    * @param coordx representa la coordenada x en el tablero del jugador
    * @param coordy representa la coordenada x en el tablero del jugador
    */
    public void borrarBarco(int coordx, int coordy){
        int[][] tab = this.getTablero();
        tab[coordy][coordx] = 0;
    }
    
    /**
    * Método para borrar un barco en una coordenada dada
     * @param posicion representa una coordenada dada
     * @return true si la coordenada esta en el formato correcto.
    */
    public boolean validar(String posicion){
        Pattern patron = Pattern.compile("\\([A-Ha-h]\\,[0-7]\\)");
        Matcher match = patron.matcher(posicion);
        return match.matches();
    }
    
    /**
    * Método para convertir la posición dada por el usuario en un arreglo
    * @param posicion representa las coordenadas en el tablero del jugador
    * @return regresa un arreglo con las coordenadas parseadas
    */
    public static int[] convertir(String posicion){
        int[] coordenadas = null;
        String coordenada = posicion.substring(1,posicion.indexOf(","));
        int coordenadaNum = parsear(coordenada);
        if(coordenadaNum >= 0){
            coordenadas = new int[2];
            coordenadas[0] = coordenadaNum;
            coordenadas[1] = Integer.parseInt(posicion.substring(posicion.indexOf(",")+1,posicion.indexOf(")")));
        }
        return coordenadas;
    }
    
    /**
    * Método para parsear la posición x dada por el usuario en un arreglo
    * @param coordenada representa la coordenada x en el tablero del jugador, la cual es requerida como letra.
    * @return regresa un entero con la coordenada parseada 
    */
    public static int parsear(String coordenada){
        coordenada = coordenada.toLowerCase();
        int num = -1;
        switch(coordenada){
            case "a":
                num = 0;
                break;
            case "b":
                num = 1;
                break;
            case "c":
                num = 2;
                break;
            case "d":
                num = 3;
                break;
            case "e":
                num = 4;
                break;
            case "f":
                num = 5;
                break;
            case "g":
                num = 6;
                break;
            case "h":
                num = 7;
            default:
                break;       
        }
        return num;
    }
    
    /**
    * Método para scannear un string y devolverlo
    * @return regresa el String que el usuario inserto
    */
    public static String Scanner(){
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        return entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
    }    

}
