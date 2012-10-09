/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cyril
 */
public class blocEmission extends Thread{
protected Socket socketEmission;
protected PrintWriter myBufferWriter;

	@Override
	public void run() {
		synchronized(this){
			try {
				socketEmission = new Socket("127.0.0.1", 2000);
				myBufferWriter = new PrintWriter(new OutputStreamWriter(socketEmission.getOutputStream()),true);
				myBufferWriter.flush();
					
				try {
					myBufferWriter.println(Program1.tamponEmissionPrg.pullInBuffer());
				} catch (InterruptedException ex) {
					Logger.getLogger(blocEmission.class.getName()).log(Level.SEVERE, null, ex);
				}

				
			} catch (UnknownHostException ex) {
				Logger.getLogger(blocEmission.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(blocEmission.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	
}
