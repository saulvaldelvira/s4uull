/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.game;


import uo.mp.battleship.player.Player;
import uo.mp.checks.ArgumentChecks;

/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 12/03/2021 
 */
public class TurnSelector {

	private boolean turn;
	private Player user; 
	private Player computer;
	
	/**
	 * Inicializa el primer turno. Siempre empieza el usuario 
	 */
	public TurnSelector(Player user, Player computer) {
		ArgumentChecks.isNotNull(user);
		ArgumentChecks.isNotNull(computer);
		
		turn = true;
		this.user=user; 
		this.computer=computer;
	}
	
	/**
	 * Devuelve el jugador al que le toca el turno
	 * 
	 * @return el jugador, de tipo Player
	 */
	public Player next() {
		if(turn) {
			turn = false;
			return user;			
		}else {
			turn = true;
			return computer;
		}
	}

	/**
	 * Cambia el valor de turn para que se repita el turno del jugador anterior 
	 */
	public void repeat() {
		turn=!turn;		
	}
	
	
}

