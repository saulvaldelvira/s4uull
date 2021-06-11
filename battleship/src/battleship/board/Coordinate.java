/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board;

import uo.mp.checks.ArgumentChecks;

/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 12/03/2021 
 */
public class Coordinate {
	
	private int row;
	private int	column;
	
	/**
	 * Constructor de una coordenada dadas la fila y la columna de la misma 
	 * @param x, int
	 * @param y, int 
	 */
	public Coordinate(int x, int y) {
		ArgumentChecks.isTrue(x>=0 && x<BoardBuilder.MAX_DIMENSION, "La coordenda x debe estar en el tablero");
		ArgumentChecks.isTrue(y>=0 && y<BoardBuilder.MAX_DIMENSION, "La coordenda y debe estar en el tablero");
		
		row = y;
		column = x;
	}

	/**
	 * Devuelve el valor del parametro column 
	 * 
	 * @return column, de tipo int 
	 */
	public int getColumn() {
		return column;
	}


	/**
	 * Devuelve el valor del parametro tow 
	 * 
	 * @return row, de tipo int 
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Devuelve el valor del parametro charColumn 
	 * 
	 * @return charColumn, de tipo int 
	 */
	public char getCharColumn(){
		return (char) ('A' + column);
	}
	
	
	/**
	 * Devuelve las coordenadas en formato String
	 * 
	 * @return las coordenadas, de tipo String 
	 */
	@Override
	public String toString() {
		String result= "Coordenada [x= " + getColumn() + ", y= "+ getRow()+ "]";
		return result;
	}

	/**
	 * Devuelve las coordenadas para el usuario en formato String, 
	 * 
	 * @return las coordenadas, de tipo String 
	 */
	public String toUserString() {
		String result= getCharColumn() + "-" + (row+1);
		return result;
	}

	/**
	 * Se mueve en una posicion hacia el norte, sur este y oeste y devuelve el 
	 * objeto coordinate de esa posicion 
	 * 
	 * @return la coordenda, de tipo Coordinate
	 */
	public Coordinate go(int direction) {
		switch(direction) {
			case 0: return new Coordinate(column-1, row);
			case 1: return new Coordinate(column, row+1);
			case 2: return new Coordinate(column+1, row);
			case 3: return new Coordinate(column, row-1);
		}
		return null;
	}
	
	/**
	 * Devuelve true si el objeto pasado como parámeto es igual a este
	 * 
	 * @return true o false, de tipo boolean 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
