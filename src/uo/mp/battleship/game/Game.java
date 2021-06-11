/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.game;

import java.util.Date;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.player.Player;
import uo.mp.checks.ArgumentChecks;
import uo.mp.checks.StateChecks;

/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 12/03/2021 
 */
public class Game {

	//Atributos constantes
	public static boolean NORMAL_MODE=false;
	public static boolean DEBUG_MODE=true;
	
	//Atributos variables
	private Player human;
	private Player computer;
	private boolean debugMode;
	private TurnSelector turns;
	private GamePresenter presenter;
	private long initialTime;
	private long finalTime;
	
	/**
	 * Constructor para objetos de la clase Game, según los parámetros rightPlayer y leftPlayer dados
	 *  
	 * @param rightPlayer, de tipo human
	 * @param leftPlayer, de tipo computer
	 */
	public Game(Player human, Player computer) {
		ArgumentChecks.isTrue(human != null, "El parámetro rightPlayer no puede ser null");
		ArgumentChecks.isTrue(computer != null, "El parámetro leftPlayer no puede ser null");
		
		this.human=human;
		this.computer= computer;
		
		human.setMyShips(new Board());
		human.setOpponentShips(new Board());
		computer.setMyShips(new Board());
		computer.setOpponentShips(new Board());
		
		setDebugMode(NORMAL_MODE);
		
		this.turns=new TurnSelector(human, computer);
	}
		
	/**
	 * Constructor para objetos de la clase Game, según los parámetros rightPlayer, 
	 * leftPlayer y size dados. 
	 *  
	 * @param rightPlayer, de tipo human
	 * @param leftPlayer, de tipo computer
	 * @param size, el tamaño del tablero, de tipo int 
	 */
	public Game(Player human, Player computer, int size) {
		ArgumentChecks.isTrue(human != null, "El parámetro rightPlayer no puede ser null");
		ArgumentChecks.isTrue(computer != null, "El parámetro leftPlayer no puede ser null");
		
		this.human=human;
		this.computer= computer;
		
		human.setMyShips(new Board(size));
		human.setOpponentShips(new Board(size));
		computer.setMyShips(new Board(size));
		computer.setOpponentShips(new Board(size));
		
		setDebugMode(NORMAL_MODE);
		
		this.turns=new TurnSelector(human, computer);
	}

	/**
	 * Método que instancia un objeto GamePresenter, encargado de enviar mensajes al usuario 
	 * @param arg, de tipo GamePresenter. No puede ser null
	 */
	public void setPresenter (GamePresenter arg) {
		ArgumentChecks.isTrue(arg!=null , "El parámetro arg no puede ser null");
		this.presenter=arg;
	}
	
	/**
	 * Devuelve el jugador humano 
	 * 
	 * @return human, de tipo human
	 */
	public Player getHuman() {
		return human;
	}
	
	/**
	 * Devuelve el jugador controlado por la máquina 
	 * 
	 * @return computer, de tipo computer
	 */
	public Player getComputer() {
		return computer;
	}
	
	/**
	 * Establece el modo de juego. 
	 * Si se le pasa como parámetro true, pondrá el modo depuración. 
	 * Si es false, el modo normal 
	 * 
	 * @param mode, de tipo boolean. 
	 */
	public void setDebugMode ( boolean mode ) {
		if(mode==false) 
			debugMode=NORMAL_MODE;		
		else
			debugMode=DEBUG_MODE;		
	}

	/**
	 * Devuelve el modo de juego 
	 * 
	 * @return debugMode, de tipo boolean 
	 */
	public boolean getDebugMode() {
		return debugMode;
	}
	
	/**
	 * Devuelve el tiempo transcurrido entre el principio y el final de juego 
	 */
	public long getTime() {
		return finalTime-initialTime;
	}
	
	/**
	 * Ejecuta el juego principal. Llama de forma alterna a los dos jugadores a 
	 * disparar, hasta que uno haya destruido por completo la flota de su oponente.
	 * 
	 */
	public void play() {
		StateChecks.isTrue(this.presenter!=null, "El objeto presenter no está instanciado ");
		this.initialTime = new Date().getTime();
		
		int damage;
		while(!human.hasWon() && !computer.hasWon()) {
			presenter.showGameStatus(human.getMyShips(), human.getOpponentShips(), debugMode);			
			if(turns.next()==human) {
				presenter.showTurn(human);
				Coordinate cord= human.makeChoice();
				
				presenter.showShootingAt(cord);
				damage=human.shootAt(cord);
				computer.setMyShips(human.getOpponentShips());
				
				presenter.showHitOrMiss(damage);
				
				if(damage>0)
					turns.repeat();
				if(human.hasWon()) 
					presenter.showWinner(human);
			}else {
				presenter.showTurn(computer);
				Coordinate cord= computer.makeChoice();
				presenter.showShootingAt(cord);
				
				damage= computer.shootAt(cord);
				human.setMyShips(computer.getOpponentShips());
				presenter.showHitOrMiss(damage);
				
				presenter.showHitOrMiss(damage);
				
				if(damage>0)
					turns.repeat();
				if(computer.hasWon()) 
					presenter.showWinner(computer);
			}				
		}
		presenter.showGameOver();
		this.finalTime = new Date().getTime();
	}
}
