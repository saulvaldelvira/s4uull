/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board;

import uo.mp.battleship.board.squares.Ship;
import uo.mp.battleship.board.squares.Water;
import uo.mp.checks.ArgumentChecks;

/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 12/03/2021 
 */
public class BoardBuilder {

//	ATRIBUTOS CONSTANTES
	public static int MIN_DIMENSION=5;
	public static int MAX_DIMENSION=20;
			
//	ATRIBUTOS VARIABLES
	private Square[][] board;
	private int size;
	
	/**
	 * Constructor de un boardbuilder con un parámetro int size
	 * @param size, de tipo int
	 * @return el propio objeto BoardBuilder
	 */
	public BoardBuilder of(int size) {
		if(size >= MIN_DIMENSION && size <=MAX_DIMENSION) {
			this.size=size;
		}else{
			this.size=Board.DEFAULT_DIMENSION;
		}				
		return this;
	}

	/**
	 * Cosntruye un array bidimensional de tipo Square
	 * @return el array construido
	 */
	public Square[][] build() {
		ArgumentChecks.isTrue(size>=MIN_DIMENSION && size <=MAX_DIMENSION , "El tamaño debe estar entre 5 y 15");
		
		Ship s1 = new Ship(1);
		Ship s2 = new Ship(1);
		Ship s3 = new Ship(1);
		Ship s4 = new Ship(1);
		
		Ship d1= new Ship(2);
		Ship d2= new Ship(2);
		Ship d3= new Ship(2);
		
		Ship c1= new Ship(3);
		Ship c2= new Ship(3);
		
		Ship b1 =new Ship(4);
		
		board = new Square[size][size];
		for(int i=0; i<board.length;i++) {
			for(int j=0; j<board[0].length;j++) {
				board[i][j]=new Square();
			}
		}
		
		board[1][1].setContent(s1);
		board[1][3].setContent(s2);
		board[1][5].setContent(s3);
		board[1][7].setContent(s4);
		
		board[3][1].setContent(d1);
		board[3][2].setContent(d1);
		board[3][4].setContent(d2);
		board[3][5].setContent(d2);
		board[3][7].setContent(d3);
		board[3][8].setContent(d3);
		
		board[5][1].setContent(c1);
		board[5][2].setContent(c1);
		board[5][3].setContent(c1);
		board[5][5].setContent(c2);
		board[5][6].setContent(c2);
		board[5][7].setContent(c2);
		
		board[7][4].setContent(b1);
		board[7][5].setContent(b1);
		board[7][6].setContent(b1);
		board[7][7].setContent(b1);
		
		for(int i=0; i<board.length; i++) {
			for(int j=0;j<board[0].length; j++) {
				if(!board[i][j].hasContent()) {
					board[i][j].setContent(new Water());
				}
			}
		}
		
		return board;
	}
}