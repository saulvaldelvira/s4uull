/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board.squares;

/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 12/03/2021 
 */
public interface Target {
	
	int shootAt();
	
	char toChar();
	
	boolean hasImpact();
	
	char toFiredChar();
	

}
