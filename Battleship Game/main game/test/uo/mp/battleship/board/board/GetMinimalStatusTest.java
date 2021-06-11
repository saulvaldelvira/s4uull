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
import uo.mp.battleship.board.Coordinate;

/**
 * @author Saúl
 *
 */
public class GetMinimalStatusTest {

	
		@Test
		public void GetMinimalStatus() {
			Board board= new Board();
			char[][] boardModel= new char[][]
				{{'\u00B7', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
				board.shootAt(new Coordinate(0,0));
				board.shootAt(new Coordinate(1,1));
			assertArrayEquals(boardModel, board.getMinimalStatus());
		}
	}


