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

/**
 * @author Saúl
 *
 */
public class ShootAtTest {

	private Board board;
	
	@Before
	public void setUp() {
		board = new Board();
	}
	
	/*
	 * Escenarios 
	 * positivos 
	 * 1- En la casilla hay agua 
	 * 2- En la casilla hay un barco al que se ha tocado
	 * 3- En la casilla hay un barco al que se ha hundido
	 * 
	 * negativos 
	 * 4- position es nulo 
	 */

//	1- En la casilla hay agua 
	/**
	 * GIVEN un tablero Board
	 * WHEN se llama al método shootAt, apuntando a una casilla con agua 
	 * THEN devuelve 0
	 */
	@Test 
	public void shootAtWater() {
		assertEquals(0, board.shootAt(new Coordinate(8,8)));
		assertTrue(board.getBoard()[8][8].isShot());
	}
	
//	2- En la casilla hay un barco al que se ha tocado
	
	/**
	 * GIVEN un tablero Board 
	 * WHEN se llama al método shootAt, apuntando a una casilla con un barco al que se ha tocado
	 * THEN devuelve 1
	 */
	@Test 
	public void shootAtShipHit() {
		assertEquals(1, board.shootAt(new Coordinate(1,3)));		
		assertTrue(board.getBoard()[3][1].isShot());
	}
	
//	 3- En la casilla hay un barco al que se ha hundido
	/**
	 * GIVEN un tablero Board 
	 * WHEN se llama al método shootAt, apuntando a una casilla con un barco al que se ha hundido
	 * THEN devuelve 2 
	 */
	@Test 
	public void shootAtWaterAlreadyShot() {
		board.shootAt(new Coordinate(1,3));
		assertEquals(2, board.shootAt(new Coordinate(1,3)));
	}
	
//	4- position es nulo 
	/**
	 * GIVEN un tablero Board
	 * WHEN se llama al método shootAt con un parámetro position nulo 
	 * THEN lanza una IllegalArgumentException
	 */
	@Test 
	(expected = IllegalArgumentException.class)
	public void nullParameter() {
		board.shootAt(null);
	}
	
}
