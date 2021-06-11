/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.util;

import java.util.Scanner;

import uo.mp.battleship.board.Coordinate;

public class IO {

	private static Scanner reader = new Scanner( System.in );

	
	public static int readInt() {
		int num = reader.nextInt();
		return num;
	}

	public static Coordinate readCoordinates () {
		System.out.print("Columna (letra): ");
		
		String c = reader.next();
		int x = c.toUpperCase().charAt(0) - 'A';
		
		System.out.print("Fila (número): ");
		
		int y = reader.nextInt() - 1;
		
		return new Coordinate (x, y);
	}
	
	
	public static void display(String string) {
		System.out.println( string );
		
	}

}