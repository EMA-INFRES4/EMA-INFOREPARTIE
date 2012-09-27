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
	public static Program1 me;
	@Override
	public void run() {
	
		Program1.me = this;
		Thread fils1 = new Thread(new Client("127.0.0.1" , 1234));
		fils1.start();
		

	}
	
	public void stage2(){
		String[] messages = new String[2];
		messages[0] = "REQ,1,2,10,11";
		messages[1] = "EXIT";
		for(int i = 0 ; i < 2 ; i++){
			try {
				tamponProducteurConsommateur.pushInBuffer(messages[i]);
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
				Logger.getLogger(Program1.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		}
		
	}
}
