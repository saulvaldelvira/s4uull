package uo.mp.log;

public class ConsoleSimpleLogger implements SimpleLogger {

	@Override
	public void log(Exception ex) {
		System.err.println( "Ha ocurrido un error:" );
		ex.printStackTrace();	}

}
