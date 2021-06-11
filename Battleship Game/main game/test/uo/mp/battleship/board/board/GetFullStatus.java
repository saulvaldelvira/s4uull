/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board.board;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.battleship.board.Board;

/**
 * @author Saúl
 *
 */
public class GetFullStatus {

	@Test
	public void GetFullStatusTest() {
		Board board= new Board();
		char[][] boardModel= new char[][]
			{{' ',' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', 'S', ' ', 'S', ' ', 'S', ' ', 'S', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', 'D', 'D', ' ', 'D', 'D', ' ', 'D', 'D', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', 'C', 'C', 'C', ' ', 'C', 'C', 'C', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', 'B', 'B', 'B', 'B', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
		assertArrayEquals(boardModel, board.getFullStatus());
	}

}
