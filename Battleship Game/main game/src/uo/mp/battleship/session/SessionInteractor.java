/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.session;



import uo.mp.battleship.ranking.Score;
import uo.mp.collections.List;

/** 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 */
public interface SessionInteractor {
	
	/**
	 * Pide al usuario un nivel de dificultad y devuelve un objeto GameLevel 
	 * como respuesta 
	 * @return el objeto, de tipo GameLevel
	 */
	GameLevel askGameLevel();

	/**
	 * Pide al usuario un nombre de usario y lo devuelve como cadena
	 * @return userName. No puede ser nulo ni estar vacío 
	 */
	String askUserName();
	
	/**
	 * Le pide al usuario que elija una opción del menú. Devuelve un número 
	 * entero que representa la opción elegida
	 * @return la elección, de tipo int
	 */
	int askNextOption();
	
	/**
	 * Pide al usario que elija el modo de depuración
	 * @return true si elije depuración, false si no 
	 */
	boolean askDebugMode ();
	
	/**
	 * Pregunta al final de juego al usuario si desea guardar su puntuación 
	 * @return true si elije sí, false si no 
	 */
	boolean doYouWantToRegisterYourScore();

	/**
	 * Recibe una lista de puntuaciones y muestra la información de las mismas
	 * @param ranking, de tipo List<Score>
	 */
	void showRanking(List<Score> ranking);
	
	/**
	 *  Recibe una lista de puntuaciones y muestra la información de las mismas
	 *  excepto el nombre de usuario
	 * @param ranking, de tipo List<Score>
	 */
	void showPersonalRanking(List<Score> ranking);
	
	/**
	 * Muestra el mensaje de error recibido como parámetro (error no fatal)
	 * @param message, de tipo String 
	 */
	void showErrorMessage(String message);
	
	/**
	 * Muestra el mensaje de error recibido como parámetro (error fatal)
	 * @param message, de tipo String 
	 */
	void showFatalErrorMessage(String message);
}
