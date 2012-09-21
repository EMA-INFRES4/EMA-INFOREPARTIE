/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.net.*;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author xtalandier
 */
public class Client {
	private Socket socket = null;
	private PrintWriter out;
	
	/**
	 * Constructor
	 * @param IP   Server Address
	 * @param port Server port
	 */
	public Client(String IP , int port){
		try {
			System.out.println("CLIENT : Try to connect");
			socket = new Socket(IP, port);
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
}
