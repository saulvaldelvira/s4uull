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
public class RepeatTest {

	private Player user; 
	private Player computer;
	private TurnSelector turn;
	
	/**
	 * GIVEN un gestor de turnos
	 * WHEN se llama al método repeat()
	 * THEN cambia el valor de turn para que el siguiente jugador sea el mismo que el actual 
	 */
	@Test
	public void repeatTest() {
		user= new Player("user"); 
		computer= new Player("Computer");
		turn = new TurnSelector(user,computer);
		 assertEquals(user, turn.next());
		 turn.repeat();
		 assertEquals(user, turn.next());
	}
}
