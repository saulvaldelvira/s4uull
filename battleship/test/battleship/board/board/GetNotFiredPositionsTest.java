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
import uo.mp.collections.ArrayList;

/**
 * @author Saúl
 *
 */
public class GetNotFiredPositionsTest {

	private Board board;
	ArrayList<Coordinate> cords;
	
	
	@Before
	public void setUp() {
		board = new Board();
		cords = new ArrayList<Coordinate>();
		for (int i=0; i<board.getBoard().length;i++) {
			for (int j=0; j<board.getBoard()[0].length;j++) {
				cords.add(new Coordinate(j,i));
			}
		}
	}
	
	/*
	 * Escenarios 
	 * 1- El tablero no ha sido usado todavía. Devuelve todas las casillas
	 * 2- Un tablero nuevo, tras haber sido disparado en una casilla que no 
	 * había sido disparada antes. Devuelve todas las casillas menos esa 
	 * 3- Un tablero nuevo, tras haber sido disparado en una casilla que ya 
	 * había sido disparada antes. Devuelve todas las casillas menos esa 
	 */

//	1- El tablero no ha sido usado todavía. Devuelve todas las casillas
	/**
	 * GIVEN Un tablero de hundir la flota
	 * WHEN se crea un tablero nuevo y se llama al método getNotFiredPositions()
	 * THEN devuelve una lista con la totalidad de las casillas del tablero 
	 */
	@Test
	public void newGridTest() {
		assertEquals(cords, board.getNotFiredPositions());
	}
	
//	2- Un tablero nuevo, tras haber sido disparado en una casilla que no 
//	 * había sido disparada antes. Devuelve todas las casillas menos esa 
	/**
	 * GIVEN Un tablero de hundir la flota
	 * WHEN se crea un tablero nuevo, se diapara a una casilla y se llama al método getNotFiredPositions()
	 * THEN devuelve una lista con todas las casillas menos las disparadas 
	 */
	@Test
	public void notFiredBefore() {
		board.shootAt(new Coordinate(0,0));
		cords.remove(0);
		assertEquals(cords, board.getNotFiredPositions());
	}
	
	/**
	 * GIVEN Un tablero de hundir la flota
	 * WHEN se crea un tablero nuevo, se diapara a una casilla dos veces y se llama al método getNotFiredPositions()
	 * THEN devuelve una lista con todas las casillas menos las disparadas 
	 */
	@Test
	public void firedTwice() {
		board.shootAt(new Coordinate(0,0));
		board.shootAt(new Coordinate(0,0));
		cords.remove(0);
		assertEquals(cords, board.getNotFiredPositions());
	}
}
