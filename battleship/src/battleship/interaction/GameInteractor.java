/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.interaction;

import uo.mp.battleship.board.Coordinate;

/**
 * @author Saúl
 *
 */
public interface GameInteractor {

	/**
	 * Genera una coordenada a la que se disparará y la devuelve
	 * @return una coordenada, de tipo Coordinate 
	 */
	Coordinate getTarget();
	
	void resetFiredPositions();
	
}
