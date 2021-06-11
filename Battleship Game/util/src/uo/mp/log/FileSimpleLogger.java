/**
 * 
 */
package uo.mp.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import uo.mp.checks.ArgumentChecks;

/**
 * @author Saúl
 *
 */
public class FileSimpleLogger implements SimpleLogger {

	public static final boolean APPEND = true;
	private String file;
	
	public FileSimpleLogger(String fileName) {
		ArgumentChecks.isNotEmpty(fileName);
		this.file=fileName;
	}

	@Override
	public void log(Exception ex) {
		try {
			BufferedWriter out = new BufferedWriter(new PrintWriter(new FileWriter(file,APPEND)));
			try {
				out.write("[" + new SimpleDateFormat("dd/MM/yy").format( new Date() ));
				out.write("-" + new SimpleDateFormat("HH:mm:ss").format(new Date() ));
				out.write("] " + ex.getMessage());
				out.newLine();
			}finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException("IOException en el logger");
		}
	}

	

}
