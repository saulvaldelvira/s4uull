/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.ranking;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import uo.mp.battleship.session.GameLevel;
import uo.mp.checks.ArgumentChecks;
/** 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 */
public class Score implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private GameLevel level;
	private long time;
	private Date date;
	
	/**
	 * Constructor de una puntuación 
	 * @param userName, el nombre de usuario. De tipo String 
	 * @param level, el nivel del juego. De tipo GameLevel
	 * @param time, el tiempo de la sesión. De tipo Date
	 */
	public Score(String userName, GameLevel level, long time) {
		ArgumentChecks.isNotEmpty(userName);
		ArgumentChecks.isNotNull(level);
		ArgumentChecks.isTrue(time>0, "El parámetro time no puede ser negativo");
		
		this.userName=userName;
		this.level=level;
		this.time=time;
		this.date=new Date();
	}
	
	/**
	 * Devuelve el valor del atributo userName
	 * @return userName, de tipo String 
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * Devuelve el valor del atributo time 
	 * @return time, de tipo long 
	 */
	public long getTime() {
		return this.time;
	}
	
	/**
	 * Devuelve el valor del atributo date
	 * @return date, de tipo Date
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * Devuelve el valor del atributo level
	 * @return level, de tipo GameLevel
	 */
	public GameLevel getLevel() {
		return this.level;
	}
	
	/**
	 * Devuelve una representación del objeto en forma de cadena 
	 * @return la cadena, de tipo String 
	 */
	public String toString() {
		String result= userName + "\t   " + 
					new SimpleDateFormat("dd/MM/yy").format( date ) + "  " 
						+ new SimpleDateFormat("HH:mm:ss").format(date) + "   " +
						level;
		switch(level) {
			case SEA: result=result+"       " ;break;
			case OCEAN: result=result+"     " ;break;
			case PLANET: result=result+"    " ;break;
		}
		result= result + time;
		return result;
	}
	
	/**
	 * Devuelve una representación del objeto en forma de cadena, excluyendo 
	 * el nombre de usuario
	 * @return la cadena, de tipo String 
	 */
	public String toPersonalString() {
		String result=  new SimpleDateFormat("dd/MM/yy").format( date ) + "   " 
				+ new SimpleDateFormat("HH:mm:ss").format(date) + "  " +
				level;
		switch(level) {
			case SEA: result=result+"       " ;break;
			case OCEAN: result=result+"     " ;break;
			case PLANET: result=result+"    " ;break;
		}
		result= result + time;
		return result;
	}
	
}
