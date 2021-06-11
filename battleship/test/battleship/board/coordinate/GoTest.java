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
public class GoTest {

	private Coordinate cord;
	
	/*
	 * Escenarios 
	 * positivos
	 * (coordendas en fila y columna distinta de 0)
	 * 1-Norte
	 * 2-Este
	 * 3-Sur
	 * 4-Oeste
	 * negativos
	 * 5-Columna A, direccion oeste 
	 * 6-Fila 0, direccion Norte
	 */

//	1-Norte
	/**
	 * GIVEN una coordenada
	 * WHEN se llama al método go con el parámetro 0
	 * THEN devuelve la coordenada al norte de esta
	 */
	@Test
	public void north() {
		cord=new Coordinate(5,5);
		assertEquals(new Coordinate(4,5), cord.go(0));
	}
	
//	2-Este
	/**
	 * GIVEN una coordenada
	 * WHEN se llama al método go con el parámetro 1
	 * THEN devuelve la coordenada al este de esta
	 */
	@Test
	public void east() {
		cord=new Coordinate(5,5);
		assertEquals(new Coordinate(5,6), cord.go(1));
	}
	
//	3-Sur
	/**
	 * GIVEN una coordenada
	 * WHEN se llama al método go con el parámetro 2
	 * THEN devuelve la coordenada al sur de esta
	 */
	@Test
	public void south() {
		cord=new Coordinate(5,5);
		assertEquals(new Coordinate(6,5), cord.go(2));
	}
	
//	4-Oeste
	/**
	 * GIVEN una coordenada
	 * WHEN se llama al método go con el parámetro 3
	 * THEN devuelve la coordenada al oeste de esta
	 */
	@Test
	public void west() {
		cord=new Coordinate(5,5);
		assertEquals(new Coordinate(5,4), cord.go(3));
	}
	
//	5-Columna A, direccion oeste 
	/**
	 * GIVEN una coordenada en la columna A
	 * WHEN se llama al método go con el parámetro 3
	 * THEN lanza una IllegalArgumentsException
	 */
	@Test
	(expected= IllegalArgumentException.class)
	public void unvalidWest() {
		cord=new Coordinate(0,0);
		cord.go(3);
	}
	
//  6-Fila 0, direccion Norte
	/**
	 * GIVEN una coordenada en la fila 0
	 * WHEN se llama al método go con el parámetro 0
	 * THEN lanza una IllegalArgumentsException
	 */
	@Test
	(expected= IllegalArgumentException.class)
	public void unvalidNorth() {
		cord=new Coordinate(0,0);
		cord.go(0);
	}
	
}
