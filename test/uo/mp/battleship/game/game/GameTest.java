/*
 * 
 * @author Sa�l Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.game.game;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.battleship.game.Game;
import uo.mp.battleship.player.Player;

/**
 * @author Sa�l(UO283685)
 * @version 28/02/2021
 *
 */
public class GameTest {

	/*
	 * Escenarios 
	 * 1- rightPlayer y leftPlayer son par�metros v�lidos 
	 * 2- rightPlayer es null 
	 * 3- leftPlayer es null
	 */

//	1- rightPlayer y leftPlayer son par�metros v�lidos 
	/**
	 * GIVEN un constructor de objetos de la clase Game
	 * WHEN se le pasan par�metros rightPlayer y leftPlayer v�lidos 
	 * THEN los crea 
	 */
	@Test
	public void validParameters() {
		Player rightPlayer = new Player("Jugador 1");
		Player leftPlayer = new Player("CPU 1");
		Game game = new Game(rightPlayer, leftPlayer);
		
		assertEquals(rightPlayer , game.getHuman());
		assertEquals(leftPlayer , game.getComputer());
	}
	
//	2- rightPlayer es null 
	/**
	 *  GIVEN un constructor de objetos de la clase Game
	 * WHEN se le pasa un par�metro rightPlayer nulo 
	 * THEN lanza un IllegalArgumentException
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void nullRightPlayer() {
		Player leftPlayer = new Player("CPU 1");
		new Game(null, leftPlayer);
	}
	
//	3- leftPlayer es null
	/**
	 * GIVEN un constructor de objetos de la clase Game
	 * WHEN se le pasa un par�metro leftPlayer nulo 
	 * THEN lanza un IllegalArgumentException 
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void nullLeftPlayer() {
		Player rightPlayer = new Player("Jugador 1");
		new Game(rightPlayer, null);
	}
}
