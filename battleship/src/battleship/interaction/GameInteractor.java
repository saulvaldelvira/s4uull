/*
 * 
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.interaction;

import uo.mp.battleship.board.Coordinate;

/**
 * @author Sa�l
 *
 */
public interface GameInteractor {

	/**
	 * Genera una coordenada a la que se disparar� y la devuelve
	 * @return una coordenada, de tipo Coordinate 
	 */
	Coordinate getTarget();
	
	void resetFiredPositions();
	
}
