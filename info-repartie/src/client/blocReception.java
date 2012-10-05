package client;

import client.tamponReception;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cyril
 */
public class blocReception extends Thread {
	private ServerSocket socketserver;
	private Socket		 socketClient;
	private BufferedReader buffer;

	@Override
	public void run() {
		try {
			socketserver = new ServerSocket(2000);
			tamponReception myTamponReception = new tamponReception(1000);
			while(true){
				socketClient = socketserver.accept();

				buffer = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

				while(!buffer.ready()) {}

				String textMess = buffer.readLine();
				
				try {
					System.out.println(textMess);
					Program1.tamponReceptionPrg.pushInBuffer(textMess);
					// traitement du message :  System.out.print(textMess);
				} catch (InterruptedException ex) {
					Logger.getLogger(blocReception.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			
			
		} catch (IOException ex) {
			Logger.getLogger(blocReception.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
}
