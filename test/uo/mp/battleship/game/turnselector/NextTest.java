/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.game.turnselector;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.battleship.game.TurnSelector;
import uo.mp.battleship.player.Player;

/**
 * @author Saúl
 *
 */
public class NextTest {

	private Player user; 
	private Player computer;
	private TurnSelector turn;
	
	/**
	 * GIVEN un controlador de turnos
	 * WHEN se llama al método next()
	 * THEN devuelve al siguient ejugador, de forma alterna entre los dos 
	 */
	@Test
	public void nextTest() {
		user= new Player("user"); 
		computer= new Player("Computer");
		turn = new TurnSelector(user,computer);
		
		assertEquals(user, turn.next());
		assertEquals(computer, turn.next());
		assertEquals(user, turn.next());
	}

}
