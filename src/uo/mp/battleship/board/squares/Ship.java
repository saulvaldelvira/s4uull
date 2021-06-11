/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board.squares;

import uo.mp.checks.ArgumentChecks;

/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 12/03/2021 
 */
public class Ship implements Target {

//	atributos constantes
	public static final int SUBMARINE = 1;
	public static final int DESTROYER = 2;
	public static final int CRUISER = 3;
	public static final int BATTLESHIP = 4;
	
//	atributos variables
	private int size;
	private int shoots;
	
	/**
	 * Constructor de barcos dado el parámetro size
	 * 
	 * @param size, de tipo int
	 */
	public Ship(int shipSize) {
		ArgumentChecks.isTrue(shipSize>=1 && shipSize<=4, "El tamaño del barco debe estar entre 1 y 4 casillas");
		size=shipSize;
	}
	
	/**
	 * Dispara el barco y devuelve el daño inflingido al mismo
	 * 1=tocado, 2= hundido
	 * @return 1 o 2, de tipo int
	 */
	@Override
	public int shootAt() {
		shoots++;
		if(shoots==size) {
			return 2;
		}
		return 1;
	}	

	/**
	 * Devuelve true si el barco ha sido disparado al menos una vez
	 * @return true o false, de tipo boolean 
	 */
	@Override
	public boolean hasImpact() {
		if(shoots>0) {
			return true;
		}
		return false;
	}

	/**
	 * Devuelve el caracter asociado a dicho barco
	 * 
	 * @return el caracter, de tipo char
	 */
	@Override
	public char toChar() {
		switch(size) {
		case 1: return 'S';
		case 2: return 'D';
		case 3: return 'C';
		case 4: return 'B';
		}
		return ' ';
	}
	
	/**
	 * Devuelve el tamaño del barco
	 * 
	 * @return size, de tipo int
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Devuelve true si el barco está hundido 
	 * 
	 * @return true o false, de tipo boolean
	 */
	public boolean isSunk() {
		if(shoots==size) {
			return true;
		}
		return false;
	}

	/**
	 * Devuelve el codigo char del barco, * si esta tocado o # si está hundido
	 * 
	 * @return el código char
	 */
	@Override
	public char toFiredChar() {
		if(shoots==size) {
			return '#';
		}else {
			return '*';
		}
	}
	
	
	
}
