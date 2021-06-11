/**
 * 
 */
package uo.mp.battleship.ranking;

import java.util.Comparator;

/**
 * @author Saúl
 *
 */
public class ScoreComparator implements Comparator<Score> {

	/**
	 * Compara dos puntuaciones por Nivel de dificualtad. A igual nivel, 
	 * compara por fecha, y a igual fecha por tiempo de la sesión 
	 */
	@Override
	public int compare(Score o1, Score o2) {
		if(o1.getLevel().compareTo(o2.getLevel())==0) {
			if(Long.valueOf(o1.getTime()).compareTo(Long.valueOf(o2.getTime())) == 0)
				return o1.getDate().compareTo(o2.getDate());
			else
				return Long.valueOf(o1.getTime()).compareTo(Long.valueOf(o2.getTime()));
		}else {
			return o1.getLevel().compareTo(o2.getLevel());
		}
	}

}
