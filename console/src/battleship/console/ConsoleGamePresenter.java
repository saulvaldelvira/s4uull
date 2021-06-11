/**
 * 
 */
package uo.mp.battleship.console;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.game.Game;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.player.Player;
import uo.mp.util.IO;

/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 26/03/2021 
 */
public class ConsoleGamePresenter implements GamePresenter{

	/**
	 * Muestra el estado de los tableros 
	 * @param left, el tablero del jugador
	 * @param right, el tablero del ordenador
	 * @param gameMode, el modo de juego en funcion del cual se mostraran los tableros 
	 */
	@Override
	public void showGameStatus(Board left, Board right, boolean gameMode) {
		complements(left.getSize());
		if(gameMode == Game.NORMAL_MODE) {
			for(int i=0; i<left.getSize();i++) {
				if(i<9) {
					System.out.print(" "+(i+1));
					System.out.print(lineToString(left.getFullStatus()[i]));
					System.out.print("       ");
					System.out.print(" "+(i+1));
					System.out.print(lineToString(right.getMinimalStatus()[i]));
					System.out.println();
				}else {
					System.out.print((i+1));
					System.out.print(lineToString(left.getFullStatus()[i]));
					System.out.print("       ");
					System.out.print((i+1));
					System.out.print(lineToString(right.getMinimalStatus()[i]));
					System.out.println();
				}
			}	
		}else{
			for(int i=0; i<left.getSize();i++) {
				if(i<9) {
					System.out.print(" "+(i+1));
					System.out.print(lineToString(left.getFullStatus()[i]));
					System.out.print("       ");
					System.out.print(" "+(i+1));
					System.out.print(lineToString(right.getFullStatus()[i]));
					System.out.println();
				}else {
					System.out.print((i+1));
					System.out.print(lineToString(left.getFullStatus()[i]));
					System.out.print("       ");
					System.out.print((i+1));
					System.out.print(lineToString(right.getFullStatus()[i]));
					System.out.println();
				}
			}				
		}		
	}

	private void complements(int size) {
		head(size);
		System.out.print("        MY SHIPS        " );
		separation(size);
		System.out.print("           OPPONENT´S SHIPS");
		System.out.println();
		System.out.print("   ");
		char c = 'A';
		for(int i=0; i<size;i++) {
			System.out.print( c + " ");
			c++;
		}
		c = 'A';
		System.out.print("          ");
		for(int i=0; i<size;i++) {
			System.out.print( c + " ");
			c++;
		}
		System.out.println();
	}
	
	private void head(int size) {
		switch(size) {
		case 10:System.out.print("");break;
		case 15: System.out.print("   ");break;
		case 20:System.out.print("       ");break;
	}
		
	}

	private void separation(int size) {
		switch(size) {
		case 10:System.out.print("");break;
		case 15:System.out.print("           ");break;
		case 20:System.out.print("                     ");break;
	}
		
	}

	/**
	 * Convierte una linea del tablero en un String para poder imprimirlo por pantalla
	 * @param grid, el array de chars que convertir a String
	 * @return el resultado, de tipo String
	 */
	private static String lineToString(char[] grid) {
		String result ="|";
		for(int i=0; i<grid.length ;i++) {
			result= result+ grid[i] + "|";
		}
		return result;
	}
	
	/**
	 * Muestra un mensaje de Game Over al terminar la partida 
	 */
	@Override
	public void showGameOver() {
		IO.display("GAME OVER");
		
	}

	/**
	 * Muestra un mensaje de felicitaciones al ganador 
	 */
	@Override
	public void showWinner(Player theWinner) {
		IO.display("THE WINNER IS " + theWinner.getName());
		
	}

	/**
	 * Muetra un mensaje en funcion del daño que ha causado el disparo 
	 */
	@Override
	public void showHitOrMiss(int damage) {
		switch(damage) {
		case 2: IO.display("Hit and sunk!, repeat turn");
				break;
		case 1: IO.display("Hit!, repeat turn ");
				break;
		case 0: IO.display("Missed shot");
				break;
		}
	}		

	/**
	 * Muestra un mensaje de quien es el turno 
	 */
	@Override
	public void showTurn(Player player) {
		IO.display("It`s " + player.getName() +"'s turn");		
	}

	/**
	 * Muestra un mensaje con la coordenda a la que se va a disparar
	 */
	@Override
	public void showShootingAt(Coordinate coordinate) {
		IO.display("Shooting at " + coordinate.toUserString());
		
	}

}
