/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.game.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.battleship.game.Game;
import uo.mp.battleship.player.Player;

/**
 * @author Saúl
 *
 */
public class SetDebugModeTest {

	private Player rightPlayer;
	private Player leftPlayer;
	private Game game;
	
	@Before
	public void setUp() {
		rightPlayer = new Player("Jugador 1");
		leftPlayer = new Player("CPU 1");
		game = new Game(rightPlayer, leftPlayer);
	}
	
	/*
	 * Escenarios
	 * 1-debugMode es true
	 * 2-debugMode es false
	 */

//	1-debugMode es true
	/**
	 * GIVEN una clase Game, que gestiona una partida de hundir la flota
	 * WHEN se llama al método setDebugMode() con el parámetro true
	 * THEN cambia el modo de juego a modo depuración 
	 */
	@Test 
	public void trueTest() {
		game.setDebugMode(true);
		assertEquals(true, game.getDebugMode());
	}
	
//	2-debugMode es false
	/**
	 * GIVEN una clase Game, que gestiona una partida de hundir la flota
	 * WHEN se llama al método setDebugMode() con el parámetro false
	 * THEN cambia el modo de juego a modo normal 
	 */
	@Test 
	public void falseTest() {
		game.setDebugMode(false);
		assertEquals(false, game.getDebugMode());
	}
}
