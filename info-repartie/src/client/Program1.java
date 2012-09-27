package client;

import java.util.logging.Level;
import java.util.logging.Logger;
import server.ServerReader;

/**
 *
 * @author xtalandier
 */
public class Program1 implements Runnable {

	public static Tampon tamponProducteurConsommateur = new Tampon(10);
	
	@Override
	public void run() {
		try {
			tamponProducteurConsommateur.pushInBuffer("REQ,1,2,10,11");
		} catch (InterruptedException ex) {
			Logger.getLogger(Program1.class.getName()).log(Level.SEVERE, null, ex);
		}
			
		Thread fils1 = new Thread(new Client("127.0.0.1" , 1234));
		fils1.start();
		
		try {
			System.out.println(tamponProducteurConsommateur.pullInBuffer());
		} catch (InterruptedException ex) {
			Logger.getLogger(Program1.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
