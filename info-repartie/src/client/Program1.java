package client;

import common.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.*;

/**
 *
 * @author xtalandier
 */
public class Program1 implements Runnable {
	
	public static Tampon tamponProducteurConsommateur = new Tampon(10);
	public static Program1 me;
	Horloge lamport = new Horloge();
	
	@Override
	public void run() {
	
		Program1.me = this;
		Thread fils1 = new Thread(new Client("127.0.0.1" , 1234));
		fils1.start();
		

	}
	
	public void stage2(){
		String[] messages = new String[5];
		messages[0] = "REQ,1,2,10,11";
		messages[1] = "REAL,3,2,10,20";
		messages[2] = "SC,6,5,10";
		messages[3] = "REP,4,3,2,8";
		messages[4] = "EXIT";
		for(int i = 0 ; i < 5 ; i++){
			try {
				// Increment clock
				lamport.tick();
				// Create message
				Message msg = new Message(messages[i], lamport.getTime());
				// Send message
				tamponProducteurConsommateur.pushInBuffer(messages[i].toString());
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Logger.getLogger(Program1.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		}
		
	}
}
