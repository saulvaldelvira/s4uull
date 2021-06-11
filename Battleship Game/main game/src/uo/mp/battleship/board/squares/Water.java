/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board.squares;

/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 12/03/2021 
 */
public class Water implements Target {
	
	/**
	 * Devuelve 0, ya que hay agua
	 * 
	 * @return 0, de tipo int
	 */
	@Override
	public int shootAt() {
		return 0;
	}

	/**
	 * Devuelve el caracter del agua no disparada ' '
	 * 
	 * @return el caracter de tipo char
	 */
	@Override
	public char toChar() {
		return ' ';
	}

	/**
	 * Como es agua, de vuelve false
	 */
	@Override
	public boolean hasImpact() {
		return false;
	}

	/**
	 * Devuelve el caracter de agua disparada '\u00B7'
	 * 
	 * return ".", de tipo char
	 */
	@Override
	public char toFiredChar() {
		return '\u00B7';
	}

}
