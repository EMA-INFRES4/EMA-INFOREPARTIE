/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xtalandier
 */
public class Client implements Runnable {
	private Socket socket = null;
	private PrintWriter out;
	private String ip;
	private int port;
	
	/**
	 * Constructor
	 * @param IP   Server Address
	 * @param port Server port
	 */
	public Client(String IP , int port){
		this.ip = IP;
		this.port = port;
	}
	
	/**
	 * Connect to server
	 */
	private void connectToServer(){
		try {
			System.out.println("CLIENT : Try to connect");
			socket = new Socket(ip, port);
			System.out.println("CLIENT : Connexion: OK");
			out = new PrintWriter(socket.getOutputStream());
		} catch (UnknownHostException e) {
			System.err.println("Impossible de se connecter à l'adresse " + socket.getLocalAddress());
		} catch (IOException e) {
			System.err.println("Aucun serveur à l'écoute du port " + socket.getLocalPort());
		}
	}
	
	/**
	 * Send a message to the server
	 * @param speech message
	 */
	public void saySomething(String speech){
		out.println(speech);
		out.flush();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
		connectToServer();
		while(true){
		saySomething("DONNEES DU TAMPON");
		}
	}
}
