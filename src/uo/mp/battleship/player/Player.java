/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.player;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp.checks.ArgumentChecks;

/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 12/03/2021 
 */
public class Player {

	private String name;
	private Board myShips;
	private Board opponentShips;
	private GameInteractor interactor;
	
	public Player(String name) {
		setName(name);
	}

	public void setInteractor ( GameInteractor arg ) {
		ArgumentChecks.isTrue(arg!=null, "El parámetro arg no puede ser null");
		this.interactor=arg;
	}
	
	/**
	 * Establece el valor para el atributo name según el parámetro dado 
	 * En caso de ser nulo o vacío, el nuevo valor de name será "computer"
	 * 
	 * @param name, de tipo String 
	 */
	public void setName(String name) {
		if(name != null && name.trim().length()>0) {
			this.name = name;
		}else {
			this.name = "computer";
		}
	}

	/**
	 * Devuelve el valor del atributo name
	 * 
	 * @return	name, el nombre de la máquina. De tipo String 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Asigna el tablero recibido como parámetro al atributo myShips
	 * 
	 * @param board, de tipo Board
	 */
	public void setMyShips(Board board) {
		myShips=board;
	}

	/**
	 * Devuelve el tablero myShips 
	 * 
	 * @return myShips, de tipo Board 
	 */
	public Board getMyShips() {
		return myShips;
	}

	
	/**
	 * Asigna el tablero recibido como parámetro al atributo opponentShips
	 * 
	 * @param board, de tipo Board
	 */
	public void setOpponentShips(Board board) {
		opponentShips=board;
	}

	/**
	 * Devuelve el tablero opponentShips 
	 * 
	 * @return opponentShips, de tipo Board 
	 */
	public Board getOpponentShips() {
		return opponentShips;
	}

	/**
	 * Dispara en las coordenadas indicadas como parámetro y devuelve un int con
	 * el nivel de daño inflingido 
	 * 
	 * @param position, de tipo Coordinate 
	 * @return el nivel de daño [0-2], dependiendo de si se ha fallado, tocado o 
	 * hundido el objetivo. De tipo int
	 */
	public int shootAt(Coordinate position) {		
		return opponentShips.shootAt(position);
	}

	/**
	 * Devuelve true en caso de que la flota del oponente haya sido totalmente
	 * destruida. En caso contrario devuelve false. 
	 * 
	 * @return true o false, de tipo boolean.
	 */
	public boolean hasWon() {
		return opponentShips.isFleetSunk();
	}
	
	/**
	 * Devuelve la coordenada a la que se debe disparar
	 * @return la coordenada, de tipo Coordinate
	 */
	public Coordinate makeChoice() {
		return interactor.getTarget();
	}

}