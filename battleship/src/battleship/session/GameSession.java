/*
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 16/04/2021
 *
 */
package uo.mp.battleship.session;

import uo.mp.battleship.game.Game;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.interaction.RandomInteractor;
import uo.mp.battleship.player.Player;
import uo.mp.battleship.ranking.GameRanking;
import uo.mp.battleship.ranking.Score;
import uo.mp.checks.ArgumentChecks;
import uo.mp.log.SimpleLogger;

/** 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 18/04/2021
 */
public class GameSession {
	private String userName;
	private SessionInteractor session;
	private GameInteractor gameInt;
	private GamePresenter presenter;
	private SimpleLogger logger;
	private GameRanking ranking;
	
	/**
	 * Ejecuta la lógica de las sesiones
	 */
	public void run() {
		userName=session.askUserName();
		int option=0;
		try {
			ranking.recover();
			do {
				option = session.askNextOption();
				try {				
					processOption(option);
				}catch(Exception e) {
					handleUserError(e);
				}
			}while(option!=0);
		}catch(RuntimeException e) {
			handleSystemError(e);
			return;
		}
		
	}
	
	/**
	 * Maneja las excepciones de tipo RuntimeException y finaliza controladamente
	 * el programa
	 * @param e, la excepción capturada
	 */
	private void handleSystemError(RuntimeException e) {
		session.showFatalErrorMessage(e.getMessage());
		logger.log(e);
	}

	/**
	 * Maneja las excepciones checkeadas y continua con el programa
	 * @param e, la excepción. De tipo Exception
	 */
	private void handleUserError(Exception e) {
		session.showErrorMessage(e.getMessage());
		logger.log(e);
	}
	
	/**
	 * Procesa la opción elegida por el usuario
	 * @param option, el numero de la acción. De tipo int
	 */
	private void processOption(int option) {
		switch(option) {
			case 0: return;
			case 1: newGame(); break;
			case 2: showPersonalRanking(); break;
			case 3: showRanking(); break;
		}		
	}

	/**
	 * Pone en marcha la partida. Antes pregunta al usuario el nivel de dificultad 
	 * y el modo de depuración
	 */
	private void newGame() {
		GameLevel level = guessLevel();
		int dimension= findDimension(level);
		boolean debug = session.askDebugMode();
		Game game = configureGame(dimension, debug);
		game.play();
		if(session.doYouWantToRegisterYourScore())
			ranking.append(new Score(userName, level, game.getTime()));
		gameInt.resetFiredPositions();
	}

	/**
	 * Configura el juego 
	 * @param dimension, la dimension del tablero 
	 * @param debug, el modo de depuración 
	 */
	private Game configureGame(int dimension, boolean debug) { 
		RandomInteractor randomInteractor = new RandomInteractor( dimension ); 
		
		
		Player user = new Player(userName);
		Player computer = new Player("Computer");
		user.setInteractor( gameInt );
		computer.setInteractor( randomInteractor );
		
		
		Game game = new Game( user, computer, dimension );
		game.setDebugMode(debug);
		game.setPresenter( presenter );
		
		return game;
	}

	/**
	 * Pregunta por consola un nivel de dificultad y lo devuelve 
	 * @return gameLevel, de tipo GameLevel
	 */
	private GameLevel guessLevel() {
		GameLevel level;
		do {
			level =session.askGameLevel();
		}while(level == null);
		return level;
	}
	
	
	/**
	 * Averigua la dimension del tablero en funcion del nivel de dificultad 
	 * escogido por el jugador
	 * @param gameLevel, de tipo GameLevel 
	 * @return 10, 15 o 20 dependidendo del nivel.
	 */
	private int findDimension(GameLevel gameLevel) {
		switch(gameLevel) {
			case SEA: return 10;
			case OCEAN: return 15;
			case PLANET: return 20;
		}
		return 0;
	}

	private void showPersonalRanking() {
		ranking.sort();
		session.showPersonalRanking(ranking.getRankingFor(userName));
	}
	
	private void showRanking() {
		ranking.sort();
		session.showRanking(ranking.getRanking());
	}
	
	public void setSessionInteractor(SessionInteractor interactor) {
		ArgumentChecks.isNotNull(interactor);
		this.session=interactor;
	}
	
	public void setGameInteractor(GameInteractor interactor) {
		ArgumentChecks.isNotNull(interactor);
		this.gameInt=interactor;
	}
	
	public void setGamePresenter(GamePresenter presenter) {
		ArgumentChecks.isNotNull(presenter);
		this.presenter=presenter;
	}
	
	public void setLogger(SimpleLogger logger) {
		ArgumentChecks.isNotNull(logger);
		this.logger=logger;
	}
	
	public void setGameRanking(GameRanking ranking) {
		ArgumentChecks.isNotNull(ranking);
		this.ranking=ranking;
	}
	
}
