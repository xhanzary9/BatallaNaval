package batallanaval;

import java.util.Scanner;

public class Tablero {
  
    /*
    * tablero Matriz que simboliza el tablero que tiene el jugador
    */
    private int[][] tablero; 
    
     /**
     * Metodo constructor  de la clase abastracta Jugador.
     */
    public Tablero(){
  
        this.tablero = new int[8][8];

    }
    
    public Tablero(int n) {
        this.tablero = new int[n][n];
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
    
    public int getSize() {
        return this.tablero.length;
    }
    
    public int getElement(int n, int m) {
        return this.tablero[n][m];
    }
    
    public boolean buscarBarco(int coordx, int coordy){
       int[][] tab = this.getTablero();
       return tab[coordy][coordx] == 1;
    }
    
    public void colocarBarco(int coordx, int coordy){
        int[][] tab = this.getTablero();
        tab[coordy][coordx] = 1;
    }
    
    public void colocarBomba(int coordx, int coordy){
        int[][] tab = this.getTablero();
        tab[coordy][coordx] = 2;
    }
    
    public void borrarBarco(int coordx, int coordy){
        int[][] tab = this.getTablero();
        tab[coordy][coordx] = 0;
    }
    
    public static int[] convertir(String posicion){
        int[] coordenadas = new int[2];
        coordenadas[0] = Integer.parseInt(posicion.substring(1,posicion.indexOf(",")));
        coordenadas[1] = Integer.parseInt(posicion.substring(posicion.indexOf(",")+1,posicion.indexOf(")")));
        return coordenadas;
    }

    public static String Scanner(){
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        return entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
    }    
    
    
}
