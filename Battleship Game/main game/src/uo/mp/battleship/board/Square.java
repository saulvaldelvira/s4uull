/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.board;

import uo.mp.battleship.board.squares.Target;
import uo.mp.checks.ArgumentChecks;

/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 12/03/2021 
 */
public class Square {
	private Target content;
	private boolean shot=false;
	
	/**
	 * Marca la casilla como disparada y devuelve 0, 1 o 2 dependiendo de si en 
	 * ella había agua o un barco, y de si se ha tocado o hundido el barco en ese caso.
	 * 
	 * @return el daño causado por el disparo, de tipo int
	 */
	public int shootAt() {
		this.shot=true;
		return content.shootAt();
	}
	
	/**
	 * Devuelve true si la casilla a sido disparada, y false si no 
	 * @return shot, de tipo boolean
	 */
	public boolean isShot() {
		return shot;
	}
	
	/**
	 * Devuelve true cuando el objeto de la casilla es un barco que ya ha sido tocado 
	 * o hundido 
	 * 
	 * @return hasImpact, boolean 
	 */
	public boolean hasImpact() {
		return content.hasImpact();
	}
	
	/**
	 * Devuelve el caracter correspondiente a esa casilla 
	 */
	public char toChar() {
		if(shot==false) {
			return content.toChar();
		}else {
			return content.toFiredChar();
		}
	}
	
	/**
	 * Guarda en la casilla el objeto de tipo Target recibido como parámetro
	 * 
	 * @param object, de tipo Target
	 */
	public Square setContent(Target object) {
		ArgumentChecks.isTrue(object!=null, "El objeto no puede ser nulo");
		content=object;
		return this;
	}
	
	/**
	 * Devuelve true si el contenido de la casilla está asignado a un objeto Target
	 * 
	 * @return true o false, de tipo boolean 
	 */
	public boolean hasContent() {
		if(content!=null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Devuelve el objeto contenido en la casilla 
	 * 
	 * @return content, de tipo Target
	 */
	public Target getContent() {
		return content;
	}
	
}
