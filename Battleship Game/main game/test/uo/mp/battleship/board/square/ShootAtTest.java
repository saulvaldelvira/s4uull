/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board.square;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.battleship.board.Square;
import uo.mp.battleship.board.squares.Ship;
import uo.mp.battleship.board.squares.Water;

/**
 * @author Saúl
 *
 */
public class ShootAtTest {

	private Square square;
	
	/*
	 * CASOS 
	 * 1-Disparo a agua
	 * 2-Disparo a Submarino(lo hunde)
	 * 3-Disparo a un destructor(lo toca)
	 * 4-Disparo a un destructor(lo hunde)
	 */
	
//	1-Disparo a agua
	/**
	 * GIVEN una casilla de un tablero que almacena agua
	 * WHEN se llama al metodo shootAt() 
	 * THEN devuelve 0
	 */
	@Test
	public void waterTest() {
		square=new Square().setContent(new Water());
		assertEquals(0, square.shootAt());
	}
	
//	2-Disparo a Submarino (lo hunde)
	/**
	 * GIVEN una casilla de un tablero que almacena un submarino
	 * WHEN se llama al metodo shootAt() 
	 * THEN devuelve 2
	 */
	@Test
	public void submarineTest() {
		square=new Square().setContent(new Ship(Ship.SUBMARINE));
		assertEquals(2, square.shootAt());
	}
	
//	 3-Disparo a un destructor(lo toca)
	/**
	 * GIVEN una casilla de un tablero que almacena un destructor intacto
	 * WHEN se llama al metodo shootAt() 
	 * THEN devuelve 1
	 */
	@Test
	public void destroyerHitTest() {
		square=new Square().setContent(new Ship(Ship.DESTROYER));
		assertEquals(1, square.shootAt());
	}
	
//	4-Disparo a un destructor(lo hunde)
	/**
	 * GIVEN una casilla de un tablero que almacena un destructor disparado ya 3 veces
	 * WHEN se llama al metodo shootAt() 
	 * THEN devuelve 2
	 */
	@Test
	public void destroyerSunkTest() {
		square=new Square().setContent(new Ship(Ship.DESTROYER));
		square.shootAt();
		assertEquals(2, square.shootAt());
	}
	
}
