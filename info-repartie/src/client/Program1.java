package client;

/**
 *
 * @author xtalandier
 */
public class Program1 implements Runnable {

	@Override
	public void run() {
		Thread fils1 = new Thread(new Client("127.0.0.1" , 1234));
		fils1.start();
	}
}
