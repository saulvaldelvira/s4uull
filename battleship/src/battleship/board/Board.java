/*
 * 
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board;



import uo.mp.battleship.board.squares.Ship;
import uo.mp.checks.ArgumentChecks;
import uo.mp.collections.ArrayList;
import uo.mp.collections.List;

/**
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 12/03/2021 
 */
public class Board {

	//Atributos constantes
	public static int DEFAULT_DIMENSION=10;
	
	//Atributos Variables
	private Square[][] grid;
	
	/**
	 * Constructor sin par�metros de un objeto de la clase grid
	 * El tama�o es de 10x10 por defecto 
	 */
	public Board() {		
		grid = new BoardBuilder().of(DEFAULT_DIMENSION).build();
	}
	
	/**
	 * Constructor de un objeto de la clase grid dada su dimensi�n 
	 * como par�metro
	 * 
	 * @param size, de tipo int. Debe estar entre 5 y 15, de lo contrario se 
	 * utilizar� el tama�o por defecto (10)
	 * 
	 */
	public Board(int size) {
		grid = new BoardBuilder().of(size).build();
	}

	/**
	 * Dadas unas coordenadas de disparo, si coinciden con un barco, devuelve 2 o 1, 
	 * dependiendo del da�o inglinjido y toca ese barco, en caso de ser agua devuelve 0. 
	 *  
	 * @param position, la coordenada, de tipo Coordinate
	 * @return 0, 1 o 2. De tipo int
	 */
	public int shootAt(Coordinate position) {
		ArgumentChecks.isTrue(position != null, "El par�metro position no puede ser null");
		return grid[position.getRow()][position.getColumn()].shootAt();
	}	
	
	/**
	 * Recorre la matriz y devuelve true si todos los barcos est�n hundidos
	 * 
	 * @return true si lo est�n, false si no lo est�n 
	 */
	public boolean isFleetSunk() {
		for(int i=0; i<grid.length;i++) {
			for ( int j=0; j<grid[0].length;j++){
				if(grid[i][j].getContent() instanceof Ship) {
					if(!((Ship) grid[i][j].getContent()).isSunk()) {
						return false;
					}
					
				}
			}
		}
		return true;
	}
	
	/**
	 * Devuelve la dimensi�n del tablero  
	 * @return el tama�o, de tipo int 
	 */
	public int getSize() {
		return grid.length;
	}

	/**
	 * Devuelve una lista con todas las coordenadas que no han sido disparadas todav�a
	 * 
	 * @return notFired, un ArrayList de objetos de la clase Coordinate
	 */
	public List<Coordinate> getNotFiredPositions() {
		List<Coordinate> notFired = new ArrayList<Coordinate>();
		for(int i=0; i<grid.length; i++) {
			for ( int j=0; j<grid[0].length;j++){
				if(!grid[i][j].isShot()) {
					notFired.add(new Coordinate(j,i));	
				}
			}			
		}
		return notFired;
	}

	/**
	 * Devuelve un array bidimensional de chars que representa el estado 
	 * del tablero seg�n la siguiente nomenclatura:
	 * 'B' = Barco de batalla 
	 * 'C' = Crucero 
	 * 'D' = Destructor
	 * 'S' = Submarino
	 * '*' = Casilla acertada (disparo exitoso)
	 * '.' = Casilla fallada (disparo en agua)
	 * ' ' = Agua
	 * 
	 * @return status, el Array bidimensional de tipo char
	 */
	public char[][] getFullStatus() {
		char[][] status = new char[grid.length][grid[0].length];
		for(int i=0; i<grid.length; i++) {
			for ( int j=0; j<grid[0].length;j++){
				status[i][j]=grid[i][j].toChar();
			}			
		}
		return status;
	}

	/**
	 * Devuelve un array bidimensional de chars que representa el estado 
	 * de las casillas disparadas del tablero seg�n la siguiente nomenclatura:	 * 
	 * '*' = Casilla acertada (disparo exitoso)
	 * '.' = Casilla fallada (disparo en agua)
	 * ' ' = Casilla no disparada 
	 * 
	 * @return status, el Array bidimensional de tipo char
	 */
	public char[][] getMinimalStatus() {
		char[][] status = new char[grid.length][grid[0].length];
		for(int i=0; i<grid.length; i++) {
			for ( int j=0; j<grid[0].length;j++){
				if(grid[i][j].isShot()) {
					status[i][j]=grid[i][j].toChar();
				}else {
					status[i][j]=' ';
				}
			}			
		}
		return status;
		
	}

	/**
	 * Devuelve una copia de la matriz 
	 * 
	 * @return gridCopy, de tipo int[][]
	 */
	public Square[][] getBoard(){
		Square[][] gridCopy = new Square[grid.length][grid[0].length];
		for(int i=0; i<grid.length; i++) {
			for ( int j=0; j<grid[0].length;j++){
				gridCopy[i][j] = grid [i][j];
			}			
		}
		return gridCopy;
	}
	

	/**
	 * Asigna el array dado como par�metro al atributo grid
	 * 
	 * @param arg, de tipo Square[][]
	 */
	protected void setSquaresForTest (Square[][] arg) {
		ArgumentChecks.isTrue(arg.length == arg[0].length, "El array debe ser cuadrado");
		ArgumentChecks.isTrue(arg.length >= BoardBuilder.MIN_DIMENSION, "La dimensi�n m�nima es 5");
		ArgumentChecks.isTrue(arg.length <= BoardBuilder.MAX_DIMENSION, "La dimensi�n m�xima es 15");
	
		grid=arg;
	}

}
