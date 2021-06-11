/**
 * 
 */
package uo.mp.battleship.console;

import java.util.ArrayList;

import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp.util.IO;

/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 26/03/2021 
 */
public class ConsolePlayerInteractor implements GameInteractor{

	private ArrayList<Coordinate> alreadyFired = new ArrayList<Coordinate>();
	
	/**
	 * Pide unas coordenadas al usuario y las devuelve
	 */
	@Override
	public Coordinate getTarget() {
		Coordinate choice = IO.readCoordinates();
		while(alreadyFired.contains(choice)) 
			choice = IO.readCoordinates();
		alreadyFired.add(choice);
		return choice;
	}

	/**
	 * Vacía la lista de posiciones ya disparadas 
	 */
	public void resetFiredPositions(){
		alreadyFired.clear();
	}

	
}
