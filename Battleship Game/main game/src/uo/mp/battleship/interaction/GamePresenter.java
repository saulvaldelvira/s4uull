/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */

package uo.mp.battleship.interaction;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.player.Player;

/**
 * Interfaz Game presenter, encargada de mostrar informacion al usuario 
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 12/03/2021
 */
public interface GamePresenter {

	/**
	 * Muestra por pantalla le estado de los tableros tanto del jugador como del 
	 * enemigo.
	 * 
	 * @param left, un tablero a mostrar
	 * @param right, el otro tablero a mostrar
	 * @param debugMode, el modo de juego. Dependiendo del cual se mostrara la flota
	 * 		  completa del oponente o solo la conocida por el jugador
	 */
	void showGameStatus(Board left, Board right, boolean gameMode);
	
	/**
	 * Muestra un mensaje si el juego ha finalizado 
	 */
	void showGameOver ();
	
	/**
	 * Muestra un mensaje de felicitación al ganador de la partida
	 * 
	 * @param theWinner, de tipo Player
	 */
	void showWinner (Player theWinner);
	
	/**
	 * Indica el resultado de un disparo( "HIT!", "MISS", "SUNK!")
	 * 
	 * @param impact, de tipo int 
	 */
	void showHitOrMiss (int damage);
		
	/**
	 * Muestra un mensaje anunicando de quien es el siguiente turno
	 */
	void showTurn(Player player);
	
	/**
	 * Muestra un mensaje anunciando que se una casilla va a ser disparada 
	 */
	void showShootingAt (Coordinate coordinate);

	
}
