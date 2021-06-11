/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.interaction;


import java.util.Random;

import uo.mp.battleship.board.Coordinate;
import uo.mp.checks.ArgumentChecks;
import uo.mp.collections.ArrayList;

/**
 *
 */
public class RandomInteractor implements GameInteractor {

	private ArrayList<Coordinate> alreadyFired = new ArrayList<Coordinate>();
	private int size;
	
	public RandomInteractor(int size) {
		ArgumentChecks.isTrue(size>0, "El tamaño no puede ser negativo");
		this.size=size;
	}
	
	@Override
	public Coordinate getTarget() {
		Random r= new Random();
		Coordinate cord= new Coordinate(r.nextInt(size), r.nextInt(size));
		while(alreadyFired.contains(cord))
			cord= new Coordinate(r.nextInt(size), r.nextInt(size));
		return cord;
	}

	@Override
	public void resetFiredPositions() {
		alreadyFired.clear();		
	}

}
