/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import common.*;

/**
 *
 * @author xtalandier
 */
public class ServerReader implements Runnable {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out = null;
	SVGWriter svg;
	
	private Message[] msgs      = new Message[1000];
	private int       msgOffset = 0;
	public ServerReader(BufferedReader in, String login){
		this.in = in;
	}
	
	
	public ServerReader(Socket s){
		socket = s;
	}


	@Override
	public void run() {
		try {
			svg = new SVGWriter("d:\\svgServer.svg");
			for (int i = 1; i < 11; i++) {
				svg.dessinerProcessus(i, "Process #" + i);
			}
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			out.println("Hi! What can I do for you ?");
			out.flush();
			boolean dontStop = true;
			while(dontStop){
				String speech = in.readLine();
				System.out.println("SERVER : He said '" + speech + "'");
				msgs[msgOffset++] = Message.fromString(speech);
				if(speech.equals("EXIT")){
					dontStop = false;
					analyze();
				}
			}
		} catch (IOException ex) {
			Logger.getLogger(ServerReader.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	/**
	 * Sort & parses messages
	 */
	private void analyze(){
		// Sort objects
		
		// Parse strings
		for(int i = 0 ; i < msgOffset ; i++){
			parse(msgs[i].getData());
		}
	}
	
	/**
	 * Parse and execute a line
	 * @param line Line to parse & execute
	 * @return If the message is exit
	 */
	private boolean parse(String line){
		boolean retVal = true;
		StringTokenizer st = new StringTokenizer(line , ",");
		String command = st.nextToken();
		System.out.println("SERVER : The command is : " + command);
		if(command.equals("REQ")){
			int numDep  = Integer.parseInt(st.nextToken());
			int numArr  = Integer.parseInt(st.nextToken());
			int dateDeb = Integer.parseInt(st.nextToken());
			int dateFin = Integer.parseInt(st.nextToken());
			svg.dessinerREQ(numDep, numArr, dateDeb, dateFin);
		}else if(command.equals("SC")){
			int num     = Integer.parseInt(st.nextToken());
			int dateDeb = Integer.parseInt(st.nextToken());
			int dateFin = Integer.parseInt(st.nextToken());
			svg.dessinerSC(num, dateDeb, dateFin);
		}
		else if(command.equals("EXIT")){
			retVal = false;
			try {
				svg.close();
			} catch (IOException ex) {
				Logger.getLogger(ServerReader.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		else if (command.equals("REP")){
			int numDep  = Integer.parseInt(st.nextToken());
			int numArr  = Integer.parseInt(st.nextToken());
			int dateDeb = Integer.parseInt(st.nextToken());
			int dateFin = Integer.parseInt(st.nextToken());
			svg.dessinerREP(numDep, numArr, dateDeb, dateFin);
		}
		else if (command.equals("REAL")){
			int numDep  = Integer.parseInt(st.nextToken());
			int numArr  = Integer.parseInt(st.nextToken());
			int dateDeb = Integer.parseInt(st.nextToken());
			int dateFin = Integer.parseInt(st.nextToken());
			svg.dessinerREAL(numDep, numArr, dateDeb, dateFin);
		}
		return retVal;
	}
	
}
