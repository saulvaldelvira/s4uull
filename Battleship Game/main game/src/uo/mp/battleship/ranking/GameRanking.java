/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.ranking;






import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import uo.mp.checks.ArgumentChecks;
import uo.mp.collections.Collections;
import uo.mp.collections.LinkedList;
import uo.mp.collections.List;
/** 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 08/05/2021
 */
public class GameRanking {
	private List<Score> scores;
	private String fileName;
	
	public GameRanking(String fileName) {
		ArgumentChecks.isNotEmpty(fileName);
		this.fileName=fileName;
		scores = new LinkedList<>();
	}
	
	
	/**
	 * Recupera el ranking de la anterior sesión
	 */
	public void recover()  {
		try {
			ObjectInputStream in = new ObjectInputStream(
											new FileInputStream(fileName));
			try {
				Object obj = null;
				while(true) {
					obj=in.readObject();
					scores.add((Score) obj);
				}
			}finally {
				in.close();
			}
		}catch(EOFException | FileNotFoundException e) {
			return;
		}catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Añade una puntuación al ranking
	 * @param score, de tipo Score
	 */
	public void append(Score score)   {
		scores.add(score);
		serialize();
	}
	
	/**
	 * Serializa la lista de puntuaciones
	 */
	private void serialize()  {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
										new FileOutputStream(fileName));
			try {
				for(Score s: scores) {
					out.writeObject(s);
				}
			}finally {
				out.close();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("El fichero indicado no se ha podido crear");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Devuelve una copia de la lista de puntuaciones
	 * @return la copia, de tipo List<Score>
	 */
	public List<Score> getRanking(){
		return new LinkedList<>(scores);
	}
	
	/**
	 * Devuelve una lista con todas las puntuaciones cuyo nombre de usuario 
	 * coincida con el dado como parámetro 
	 * @param userName, el usuario a buscar
	 * @return scoresCopy, la lista filtrada
	 */
	public List<Score> getRankingFor(String userName){
		List<Score> scoresCopy = new LinkedList<>();
		
		for(Score score: scores) {
			if(score.getUserName().equals(userName))
				scoresCopy.add(score);
		}
		
		return scoresCopy;
	}

	/**
	 * Organiza la lista de puntuaciones por nivel de dificualtad, tiempo y fecha
	 */
	public void sort() {
		Collections.sort(scores, new ScoreComparator());		
	}
	
}
