/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board.coordinate;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.battleship.board.Coordinate;

/**
 * @author Saúl
 *
 */
public class ToUserStringTest {

	@Test
	public void test() {
		Coordinate cord=new Coordinate(0, 2);
		System.out.println(cord.getCharColumn());
		assertEquals("A-3", cord.toUserString());
	}

}
