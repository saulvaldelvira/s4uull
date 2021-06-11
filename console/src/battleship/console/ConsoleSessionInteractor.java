/**
 * 
 */
package uo.mp.battleship.console;

import java.io.PrintStream;
import java.util.Scanner;

import uo.mp.battleship.ranking.Score;
import uo.mp.battleship.session.GameLevel;
import uo.mp.battleship.session.SessionInteractor;
import uo.mp.collections.List;

/** 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 18/04/2021
 */
public class ConsoleSessionInteractor implements SessionInteractor{

	private static PrintStream out = System.out;
	private static PrintStream err = System.err;
	private static Scanner keyboard = new Scanner( System.in );
	
	@Override
	public GameLevel askGameLevel() {
		out.println("Level? (S)ea, (O)cean, (P)lanet");
		String str = keyboard.next();
		if(str.equals("S"))
			return GameLevel.SEA;
		else if(str.equals("O"))
			return GameLevel.OCEAN;
		else if(str.equals("P"))
			return GameLevel.PLANET;
		else return null ;
	}

	@Override
	public String askUserName() {
		String str;
		
		do {
			out.println("Player name?");
			str = keyboard.next();
		}while(str.isBlank());
		
		return str;
	}

	@Override
	public int askNextOption() {
		out.println("Avalible options:");
		out.println("1- Play a new game");
		out.println("2- Show my results");
		out.println("3- Show all results");
		out.println("0- Exit");
		int option;
		do {
			option = keyboard.nextInt();
		}while(!(option>=0 && option <=3));
		return option;
	}

	@Override
	public boolean askDebugMode() {
		out.println("Do you want to play in debug mode? (y)es, (n)o");
		String str = keyboard.next();
		return str.equals("y");
	}

	@Override
	public boolean doYouWantToRegisterYourScore() {
		out.println("Do you want to register your score? (y)es, (n)o");
		String str = keyboard.next();
		return str.equals("y");
	}

	@Override
	public void showRanking(List<Score> ranking) {
		out.println("User Name .Date	    .Hour      .Level    .Time");
		for(Score score:ranking) {
			out.println(score);
		}
		
	}

	@Override
	public void showPersonalRanking(List<Score> ranking) {
		out.println("Date	  .Hour     .Level    .Time");
		for(Score score:ranking) {
			out.println(score.toPersonalString());
		}
		
	}

	
	@Override
	public void showErrorMessage(String message) {
		err.println("Ha ocurrido un error: " + message);
		err.println("Vuelva a elegir una opción");		
	}

	@Override
	public void showFatalErrorMessage(String message) {
		err.println("Ha ocurrido un error irrecuperable: " + message);
		err.println("La ejecucion del programa se detendrá");
		
	}

}
