/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board.board;

import static org.junit.Assert.*;




import org.junit.Before;
import org.junit.Test;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.collections.List;

/**
 * @author Saúl
 *
 */
public class IsFleeSunkTest {

	private Board board;
	
	@Before
	public void setUp() {
		board = new Board();
	}
	
	
	/*
	 * Escenarios 
	 * cuando quedan varios barcos a flote
	 * 1-Tras un disparo fallido, devuelve false
	 * 2-Tras un disparo que toca pero que no hunde un barco, devuelve false
	 * 3-Tras un disparo que hunde uno de los barcos, si aún quedan barcos a flote, devuelve false.
	 * cuando solo hay un barco a flote
	 * 4-Tras un disparo acertado que lo hunde, devuelve true 
	 * 
	 */

//	1-Tras un disparo fallido, devuelve false
	/**
	 * GIVEN un tablero de undir la flota con varios barcos
	 * WHEN se llama al método isFleeStunk() tras un disparo fallido 
	 * THEN devuelve false
	 */
	@Test 
	public void failedShotTest() {
		board.shootAt(new Coordinate(9,9));
		assertFalse(board.isFleetSunk());
	}
	
//	2-Tras un disparo que toca pero que no hunde un barco, devuelve false
	/**
	 * GIVEN un tablero de undir la flota con varios barcos
	 * WHEN se llama al método isFleeStunk() tras un disparo que toca un barco
	 * THEN devuelve false
	 */
	@Test 
	public void touchedShotTest() {
		
		
		board.shootAt(new Coordinate(8,8));
		assertFalse(board.isFleetSunk());
	}
	
//	3-Tras un disparo que hunde uno de los barcos, si aún quedan barcos a flote, devuelve false.
	/**
	 * GIVEN un tablero de undir la flota con varios barcos
	 * WHEN se llama al método isFleeStunk() tras un disparo que hunde un barco, pero quedan más
	 * THEN devuelve false
	 */
	@Test 
	public void sunkShotButMoreShipsTest() {
		board.shootAt(new Coordinate(0,0));
		assertFalse(board.isFleetSunk());
	}
	
//	4-Tras un disparo acertado que hunde el ultimo barco, devuelve true 
	/**
	 * GIVEN un tablero de undir la flota con varios barcos
	 * WHEN se llama al método isFleeStunk() tras un disparo que hunde el último barco del tablero
	 * THEN devuelve true
	 */
	@Test 
	public void sunkLastShipTest() {		
		List<Coordinate> notFired = board.getNotFiredPositions();
		for(Coordinate cord: notFired) {
			board.shootAt(cord);
		}
		assertTrue(board.isFleetSunk());
	}
}
