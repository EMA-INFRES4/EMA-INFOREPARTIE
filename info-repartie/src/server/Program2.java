package server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xtalandier
 */
public class Program2 implements Runnable {

	@Override
	public void run() {
		try {
			Server srv;
			srv = new Server();
			srv.run();
		} catch (IOException ex) {
			Logger.getLogger(Program2.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
